package com.lxg.database.redis;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ShardedJedisPool;

import java.util.List;

/**
 * @author xuegangliu
 *  11/13/2018 12:19 PM
 *
 * @version: v1.0
 */
@Slf4j
public class RedisUtils {

    /**
     * 集群
     * @param jedisShardInfo 集群信息
     * @return
     */
    public static ShardedJedisPool getConnetcShardedRedis(List jedisShardInfo){
        log.info( "获取集群连接池" );
        ShardedJedisPool pool;
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(50);
        config.setMaxWaitMillis(3000);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        pool = new ShardedJedisPool(config, jedisShardInfo);
        return pool;
    }

    /**
     * 单个连接获取
     * @param host
     * @param port
     * @param password
     * @return
     */
    public static Jedis getConnectJedis(String host, int port, String password){
        log.info("jedis connect params [host={},port={},password={}]",host,port,password );
        Jedis jedis = new Jedis(host,port);
        jedis.auth(password);
        return jedis;
    }
}
