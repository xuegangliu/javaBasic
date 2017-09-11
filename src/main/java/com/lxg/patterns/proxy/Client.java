package com.lxg.patterns.proxy;

/**
 * Created by Coder-pig on 2017/3/3 0003.
 * 代理模式
 */

public class Client {
    public static void main(String[] args) {
        Agent agent = new Agent();
        agent.fetchShoes();
    }
}
