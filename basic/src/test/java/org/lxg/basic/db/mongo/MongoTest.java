package org.lxg.basic.db.mongo;

import com.alibaba.fastjson.JSON;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * @author xuegangliu
 *  11/13/2018 1:39 PM
 *
 * @version: v1.0
 */
public class MongoTest {

//    @Test
    public void connectTest(){
        MongoClient mongoClient = MongoUtils.connectMongo("140.143.250.99", 27017,"mongodb",
                "lxgmongo", "admin");
        MongoDatabase db = mongoClient.getDatabase( "test" );
        db.drop();
        // 创建表
        List<Document> list = new ArrayList<Document>();
        HashMap t = new HashMap(  );
        t.put( "name","tony" );
        t.put( "age",18 );
        t.put( "birthday",new Date());
        Document document1 = new Document("persn",t);
        t.put( "age",19 );
        Document document2 = new Document("persn",t);
        t.put( "age",20 );
        Document document3 = new Document("persn",t);
        list.add( document1 );
        list.add( document2 );
        list.add( document3 );
        // 插入集合数据
        db.getCollection( "info" ).insertMany( list );

        MongoCollection collection = db.getCollection( "info" );
        FindIterable findIterable = collection.find();
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()) {
            Document doc = (Document) cursor.next();
            System.out.println(doc.get("_id") + "," + JSON.toJSONString(doc));
        }

    }
}
