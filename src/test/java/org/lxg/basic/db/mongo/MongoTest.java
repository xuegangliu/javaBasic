package org.lxg.basic.db.mongo;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author: xuegangliu
 * @date: 11/13/2018 1:39 PM
 * @DES:
 * @version: v1.0
 */
public class MongoTest {

    @Test
    public void connectTest(){
        MongoClient mongoClient = MongoUtils.connectMongo("140.143.250.99", 27017,"mongodb",
                "lxgmongo", "admin");
        MongoDatabase db = mongoClient.getDatabase( "test" );
        db.drop();
        // 创建表
        List<Document> list = new ArrayList<Document>();
        Document document1 = new Document("name","tony" );
        Document document2 = new Document("age",18 );
        Document document3 = new Document("birthday",new Date());
        list.add( document1 );
        list.add( document2 );
        list.add( document3 );
        // 插入集合数据
        db.getCollection( "info" ).insertMany( list );

    }
}
