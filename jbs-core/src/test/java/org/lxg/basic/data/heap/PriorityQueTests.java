package org.lxg.basic.data.heap;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * PriorityQueTests
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/11/08
 * @since 1.8
 **/
@Slf4j
public class PriorityQueTests {

    @Test
    public void priorityQueTest(){
        PriorityQue priorityQue=new PriorityQue(10);
        priorityQue.insert(4);
        priorityQue.insert(1);
        priorityQue.insert(6);
        priorityQue.insert(2);
        priorityQue.insert(9);
        priorityQue.insert(5);
        log.error("peekMin:{}",priorityQue.peekMin());
        log.error("remove:{}",priorityQue.remove());
        log.error("peekMin:{}",priorityQue.peekMin());
    }
}
