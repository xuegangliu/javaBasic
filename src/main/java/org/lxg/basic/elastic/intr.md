# Java > elasticsearch

如果你使用的是 JAVA，Elasticsearch 内置了两个客户端，你可以在你的代码中使用：
节点客户端: 节点客户端以一个 无数据节点 的身份加入了一个集群。换句话说，它自身是没有任何数据的，但是他知道什么数据在集群中的哪一个节点上，然后就可以请求转发到正确的节点上并进行连接。
传输客户端: 更加轻量的传输客户端可以被用来向远程集群发送请求。他并不加入集群本身，而是把请求转发到集群中的节点。
这两个客户端都使用 Elasticsearch 的 传输 协议，通过9300端口与 java 客户端进行通信。集群中的各个节点也是通过9300端口进行通信。如果这个端口被禁止了，那么你的节点们将不能组成一个集群。
请求格式

```      
<1>     <2>                   <3>    <4>
curl -XGET 'http://localhost:9200/_count?pretty' -d '
{  <5>
    "query": {
        "match_all": {}
    }
}
```
 
1. 相应的 HTTP 请求方法 或者 变量 : GET, POST, PUT, HEAD 或者 DELETE。

1. 集群中任意一个节点的访问协议、主机名以及端口。

1. 请求的路径。

1. 任意一个查询后再加上 ?pretty 就可以生成 更加美观 的JSON反馈，以增强可读性。

1. 一个 JSON 编码的请求主体（如果需要的话）。


## 搜索

 1. 检索文档  _index/_type/_id
 
 2. 简易搜索 _search
 
 3. 轻量级搜索 _search?q=xx
 
 4. QueryDSL 
      {
           "query":{
                  {xx}   
             }
      }
      
 5. 全文搜索```{"query":{"match":{"xx":"xx"}}}```
 
 6. 段落搜索```{"query":{"match_phrase":{"xx":"xx"}}}```
 
 7. 高亮搜索```{"query":{"match_phrase":{"xx":"xx"}} ,"highlight":{"fields":{"about":{}}}}``
     
## 统计```{"query":{},"aggs":{"all_interests":{"terms":{"field":"xx"}}}}```

## 集群

     集群 (cluster), 节点 (node) 以及 分片 (shard)
     集群健康 /_cluster/health >> status 有green、yellow、red三种
     green：所有主要分片和复制分片都可用，yellow：所有主要分片可用，但不是所有复制分片都可用，red：不是所有的主要分片都可用
     
## 索引添加

     索引->分片(最小级别工作单元(主分片\复制分片))->文档
     文档->主分片(决定索引最多能存储多少数据)
          设置分片{"settings":{"number_of_shards":3,"number_of_replicas":1}}
          
## 故障转移

     添加一个节点(将复制分片添加到第二个节点)
     横向扩展--分布节点
     
## 数据

     文档、索引、获取、存在、更新、创建、删除、版本控制、局部更新、Mget(/_mget{"docs":[{}]})
          批量(_bulk{"create":{xx}}
                              {"create":{xx}}
          })==>{"xx":"xx","items":[{}]}

## 分布式增删改查

     路由(routing[shard=hash(routing)%number_of_primary_shards])
