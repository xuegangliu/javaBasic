package com.lxg.open.netty;

import com.lxg.open.netty.udp.LogEventBroadcaster;
import com.lxg.open.netty.udp.LogEventMonitor;
import io.netty.channel.Channel;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * UdpTests
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2020/07/08
 * @since 1.8
 **/
public class UdpTests {

    @Test
    public void test1(){
        System.out.println(UdpTests.class.getClassLoader().getResource("").getPath());
    }

    @Test
    public void logEventBroadcasterTest() throws IOException {
        int port = 4096;
        String path = UdpTests.class.getClassLoader().getResource("").getPath() + "/log.txt";
        LogEventBroadcaster broadcaster = new LogEventBroadcaster(new InetSocketAddress(
                "255.255.255.255", port), new File(path));
        try {
            broadcaster.run();
        } finally {
            broadcaster.stop();
        }
    }

    @Test
    public void logEventMonitorTest() throws InterruptedException {
        LogEventMonitor monitor = new LogEventMonitor(new InetSocketAddress(4096));
        try {
            Channel channel = monitor.bind();
            System.out.println("LogEventMonitor running");
            channel.closeFuture().sync();
        } finally {
            monitor.stop();
        }
    }
}
