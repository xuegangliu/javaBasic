package com.lxg.open.redisson;

import com.lxg.open.utils.PropertiesUtils;
import org.redisson.Redisson;
import org.redisson.config.Config;

/**
 * RedissonManager
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/07/17
 * @since 1.8
 **/
public class RedissonManager {

    private static Config config = new Config();

    /**
     * 声明redisso对象
     */
    private static Redisson redisson = null;
    //实例化redisson
    static{
        config.useSingleServer()
                .setAddress(PropertiesUtils.properties.getProperty("redis.host.port"))
                .setPassword(PropertiesUtils.properties.getProperty("redis.password"))
                .setDatabase(Integer.parseInt(PropertiesUtils.properties.getProperty("redis.database.select")));
        //得到redisson对象
        redisson = (Redisson) Redisson.create(config);
    }

    /**
     * 获取redisson对象的方法
     * @return
     */
    public static Redisson getRedisson(){
        return redisson;
    }
}
