package com.github.jwxa.netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.InetAddress;

/**
 * 标题<br>
 * User: Jwxa<br>
 * Date: 2016/8/31.
 */
public class HelloServerHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println(channelHandlerContext.channel().remoteAddress()+" Say:" + s);
        channelHandlerContext.writeAndFlush("Received your message ! \n");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("RamoteAddress:" + ctx.channel().remoteAddress() + " active !");
        ctx.writeAndFlush("Welcome to "+ InetAddress.getLocalHost().getHostName() + " service!\n");
        super.channelActive(ctx);
    }
}
