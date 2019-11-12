package org.lxg.basic.data.graph;

import org.junit.Test;

/**
 * GraphTests
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/11/12
 * @since 1.8
 **/
public class GraphTests {

    @Test
    public void sampleTest(){
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0, 1);//AB
        graph.addEdge(1, 2);//BC
        graph.addEdge(0, 3);//AD
        graph.addEdge(3, 4);//DE

        System.out.println("深度优先搜索算法 :");
        //ABCDE
        graph.depthFirstSearch();

        System.out.println();
        System.out.println("----------------------");

        System.out.println("广度优先搜索算法 :");
        //ABDCE
        graph.breadthFirstSearch();
    }
}
