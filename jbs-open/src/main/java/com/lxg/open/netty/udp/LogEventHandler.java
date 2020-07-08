package com.lxg.open.netty.udp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * LogEventHandler
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2020/07/08
 * @since 1.8
 **/
public class LogEventHandler extends SimpleChannelInboundHandler<LogEvent> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogEvent msg) throws Exception {
        StringBuilder builder = new StringBuilder();
        builder.append(msg.getReceived());
        builder.append(" [");
        builder.append(msg.getSource().toString());
        builder.append("] [");
        builder.append(msg.getLogfile());
        builder.append("] : ");
        builder.append(msg.getMsg());
        System.out.println(builder.toString());
    }
}
