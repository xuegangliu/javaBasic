package com.lxg.problem.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * HashWalkBench
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/08/22
 * @since 1.8
 **/
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 3, jvmArgsAppend = {"-Xms4g", "-Xmx4g", "-Xmn2g"})
@Threads(Threads.MAX)
public class HashWalkBench {
    @Param({"16", "256", "4096", "65536", "1048576", "16777216"})
    int size;
    Map<String, String> map;
    @Setup
    public void setup() throws Exception {
        create();
        System.gc();
    }
    private void create() {
        String[] keys = new String[size];
        String[] values = new String[size];
        for (int c = 0; c < size; c++) {
            keys[c] = "Key" + c;
            values[c] = "Value" + c;
        }
        map = new HashMap<>(size);
        for (int c = 0; c < size; c++) {
            String key = keys[c];
            String val = values[c];
            map.put(key, val);
        }
    }
    @Benchmark
    public void walk(Blackhole bh) {
        for (Map.Entry<String, String> e : map.entrySet()) {
            bh.consume(e.getKey());
            bh.consume(e.getValue());
        }
    }
}
