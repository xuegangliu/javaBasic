package com.lxg.problem.jmh;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * BenchmarkTest
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/08/21
 * @since 1.8
 **/
@Slf4j
public class BenchmarkTest {

    @Test
    public void testBenchmark1() throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Benchmark1.class.getSimpleName())
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(opt).run();
    }

    @Test
    public void testBenchmark2() throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Benchmark2.class.getSimpleName())
                .forks(2)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(opt).run();
    }
}
