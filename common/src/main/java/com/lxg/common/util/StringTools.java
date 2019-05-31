package com.lxg.common.util;

/**************************
 *  StringTools
 * @author xuegangliu
 *  2019/3/6 15:50
 ***************************/
public final class StringTools {

    public static int getSubCount(String str, String key) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(key, index)) != -1) {
            index = index + key.length();
            count++;
        }
        return count;
    }

    public static String getSql(String sql,String[] args){
        int count = getSubCount(sql,":");
        if(count!=args.length) {
            return "";
        }
        int num = 1;
        for(String t:args){
            sql = sql.replace(":"+num,t);
            num++;
        }
        return sql;
    }
}
