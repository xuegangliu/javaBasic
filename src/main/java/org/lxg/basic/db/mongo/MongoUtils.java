package org.lxg.basic.db.mongo;

import com.mongodb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author: xuegangliu
 * @date: 11/13/2018 1:37 PM
 * @DES:
 * @version: v1.0
 */
public class MongoUtils {

    private static Logger logger = LoggerFactory.getLogger( MongoUtils.class );

    public static MongoClient connectMongo(String host,int port,String userName,String password,String databse){
        MongoCredential credential = MongoCredential.createCredential(userName, databse, password.toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress(host, port), Arrays.asList(credential));
        logger.info( "Connect to database successfully" );
//        DB database = mongoClient.getDB(databse);//获取数据库
        return mongoClient;
    }
}
