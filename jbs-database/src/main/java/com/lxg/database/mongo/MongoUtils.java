package com.lxg.database.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author xuegangliu
 *  11/13/2018 1:37 PM
 *
 * @version: v1.0
 */
@Slf4j
public class MongoUtils {


    public static MongoClient connectMongo(String host, int port, String userName, String password, String databse){
        MongoCredential credential = MongoCredential.createCredential(userName, databse, password.toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress(host, port), Arrays.asList(credential));
        log.info( "Connect to database successfully" );
//        DB database = mongoClient.getDB(databse);//获取数据库
        return mongoClient;
    }
}
