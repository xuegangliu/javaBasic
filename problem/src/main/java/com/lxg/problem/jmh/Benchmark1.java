package com.lxg.problem.jmh;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.TimeUnit;

/**
 * Benchmark1
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/08/21
 * @since 1.8
 **/
@Slf4j
@BenchmarkMode(Mode.All)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class Benchmark1 {

    @Benchmark
    public int sleepAWhile() {
        try {
            Thread.sleep(500);
            log.info("{}",Thread.currentThread().getId());
        } catch (InterruptedException e) {
            // ignore
        }
        return 0;
    }
}
