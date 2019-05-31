package org.lxg.basic.elastic;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Set;

/**
 * @author xuegangliu
 */
public class EsClient {

    /**
     * elasticsearch 集群名
     */
    final String cluster = "elap";

    /**
     * 服务器地址
     */
    final String serverIP = "192.168.113.97";

    /**
     * 服务器端口
     */
    final Integer port = 9300;

    /**
     * 索引
     */
    final String index = "elap_0";

    /**
     * 索引名前缀
     */
    final String createIndex = "elap_1";

    /**
     * type
     */
    final String type = "message";

    /**
     * client
     */
    private Client client;

    /**
     * 初始化客户端连接
     */
    @Before
    public void initESClient() {
        // 配置你的es,现在这里只配置了集群的名,默认是elasticsearch,跟服务器的相同
        Settings settings = Settings.settingsBuilder().put("cluster.name",cluster).build();
        // 这里可以同时连接集群的服务器,可以多个,并且连接服务是可访问的
        try {
            client = TransportClient.builder().settings(settings).build()
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(serverIP),port));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println("连接成功！");
    }

    @After
    public void closeESClient() {
        client.close();
        System.out.println("连接关闭！");
    }

    public static void main(String[] args){
        System.out.println("ES集群连接测试");
        EsClient esc = new EsClient();
        esc.initESClient();
        esc.createIndex();
        esc.search();
        esc.getIndex();
        esc.get();
        esc.delete();
        esc.closeESClient();
    }

    /**
     * 创建索引
     */
    private void createIndex() {
        int size = 10;
        for(int i=0; i<size; i++){
            String id = "id"+i;
            String title = "this is title" + i;
            client.prepareIndex(createIndex, type).setSource(getBuilderJson(id, title)).execute().actionGet();
        }
        System.out.println("createIndex索引创建成功！");
    }
    private String getBuilderJson(String id,String title){
        String json = "";
        try {
            XContentBuilder contentBuilder = XContentFactory.jsonBuilder().startObject();
            contentBuilder.field("id",id);
            contentBuilder.field("title",title);
            json = contentBuilder.endObject().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
    /**
     * 查询某个索引中的内容
     */
    public void getIndex() {
        GetResponse res = client.prepareGet().setIndex(createIndex)
                .setType(type).setId("AV0woC3Cnr7tefwW8RTV").execute().actionGet();
        System.out.println("get id:AV0woC3Cnr7tefwW8RTV==>"+res.getSource());
    }
    /**
     * 搜索索引
     */
    public void search(){
        //创建查询索引
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(createIndex);
        //设置查询索引类型
        searchRequestBuilder.setTypes(type);
        //设置查询类型
        //1.SearchType.DFS_QUERY_THEN_FETCH = 精确查询
        // 2.SearchType.SCAN = 扫描查询,无序
        // 3.SearchType.COUNT = 不设置的话,这个为默认值,还有的自己去试试吧
        searchRequestBuilder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
        //设置查询关键字
        // fieldQuery 这个必须是你的索引字段哦,不然查不到数据,这里我只设置两个字段 id ,title
        // 设置查询数据的位置,分页用吧
        searchRequestBuilder.setFrom(0);
        // 设置查询结果集的最大条数
        searchRequestBuilder.setSize(60);
        // 设置是否按查询匹配度排序
        searchRequestBuilder.setExplain(true);
        // 最后就是返回搜索响应信息
        SearchResponse response = searchRequestBuilder.execute().actionGet();
        System.out.println(response);

        //获取搜索文档的结果
        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        System.out.println(hits.length);
        for (int i = 0; i < hits.length; i++) {
            SearchHit hit = hits[i];
            Map result = hit.getSource();
            System.out.println(result);
        }
        System.out.println("search end查询索引完毕!");
    }

    /**
     * 获取索引
     */
    public void get(){
        GetResponse response = client.prepareGet(createIndex, type, "AV0woC3Cnr7tefwW8RTV")
                .execute().actionGet();
        //下面是不在多线程操作，他默认为.setOperationThreaded(true)
        //GetResponse response = client.prepareGet("blog", "post", "AVJjRJVqW-UsQoTouwCF")
        Set<String> headers = response.getHeaders();
        System.out.println(headers);
        //获取请求头
        boolean exists = response.isExists();
        //判断索引是否存在
        System.out.println(exists);
        String sourceString = response.getSourceAsString();
        //获取索引，并打印出索引内容
        System.out.println(sourceString);
        String id = response.getId();
        //获取索引id
        System.out.println(id);
        boolean sourceEmpty = response.isSourceEmpty();
        //获取索引的内容是否为空
        System.out.println(sourceEmpty);
    }
    /**
     * 删除索引
     */
    public void delete(){
        DeleteResponse response = client.prepareDelete(createIndex, type, "AVJjRJVqW-UsQoTouwCF")
                .execute().actionGet();
        //下面是不在多线程操作，他默认为.setOperationThreaded(true)
        //GetResponse response = client.prepareDelete("blog", "post", "AVJjRJVqW-UsQoTouwCF")
        boolean isFound = response.isFound();
        //返回索引是否存在，存在删除
        System.out.println(isFound);

    }
}
