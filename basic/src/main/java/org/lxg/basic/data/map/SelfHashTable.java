package org.lxg.basic.data.map;

import java.util.TreeMap;

/**
 * @author xuegangliu
 * 自定义hashtable结构
 * @param <K>
 * @param <V>
 */
public class SelfHashTable<K, V> {
    private static final int UPPERTOL = 10;
    private static final int LOWERTOL = 2;
    private static final int INITCAPACITY = 7;

    private TreeMap<K, V>[] hashtable;
    private int size;
    private int m;

    public SelfHashTable(int m){
        this.m = m;
        size = 0;
        hashtable = new TreeMap[m];
        for(int i = 0 ; i < m ; i ++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    public SelfHashTable(){
        this(INITCAPACITY);
    }

    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public int getSize(){
        return size;
    }

    public void add(K key, V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        if(map.containsKey(key)) {
            map.put(key, value);
        }else{
            map.put(key, value);
            size ++;

            if(size >= UPPERTOL * m) {
                resize(2 * m);
            }
        }
    }

    public V remove(K key){
        V ret = null;
        TreeMap<K, V> map = hashtable[hash(key)];
        if(map.containsKey(key)){
            ret = map.remove(key);
            size --;
            int k = 2;
            if(size < LOWERTOL * m && m / k >= INITCAPACITY) {
                resize(m / 2);
            }
        }
        return ret;
    }

    public void set(K key, V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        if(!map.containsKey(key)) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }

        map.put(key, value);
    }

    public boolean contains(K key){
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key){
        return hashtable[hash(key)].get(key);
    }

    private void resize(int newLength){
        TreeMap<K, V>[] newHashTable = new TreeMap[newLength];
        for(int i = 0 ; i < newLength ; i ++) {
            newHashTable[i] = new TreeMap<>();
        }

        int oldValue = m;
        this.m = newLength;
        for(int i = 0 ; i < oldValue ; i ++){
            TreeMap<K, V> map = hashtable[i];
            for(K key: map.keySet()) {
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }

        this.hashtable = newHashTable;
    }
}

