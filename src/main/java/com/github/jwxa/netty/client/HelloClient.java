package com.github.jwxa.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 标题<br>
 * User: Jwxa<br>
 * Date: 2016/8/31.
 */
public class HelloClient {

    public static String host = "127.0.0.1";
    public static int port = 7878;

    public static void main(String[] args) throws IOException, InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .handler(new HelloClientInitializer());
            //连接服务端
            Channel ch  = b.connect(host,port).sync().channel();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            for(;;){
                String line = in.readLine();
                if(line ==null){
                    continue;
                }
                /**
                 * 向服务端发送在控制台输入的文本 并用"\r\n"结尾
                 * 之所以用\r\n结尾 是因为我们再handler中添加了 DelimiterBasedFrameDecoder帧解码。
                 * 这个解码器是一个根据\n符号位分隔符的解码器。所以每条消息的最后必须加上\n
                 * 否则无法识别和解码
                 */

            ch.writeAndFlush(line+"\r\n");
            }
        }finally {
            group.shutdownGracefully();
        }
    }
}
