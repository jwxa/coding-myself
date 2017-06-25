package com.github.jwxa.netty.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * http://www.ibm.com/developerworks/cn/education/java/j-nio/j-nio.html<br>
 * NIO测试<br>
 * User: Jwxa<br>
 * Date: 2016/9/2.
 */
public class NioTest {
    /**
     * 读取文件
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //1.第一步是获取通道。我们从 FileInputStream 获取通道：
        String file = NioTest.class.getClassLoader().getResource("test.txt").getPath();
        System.out.println(file);
        FileInputStream fis = new FileInputStream(file);
        FileChannel channel =  fis.getChannel();
        //2.下一步是创建缓冲区：
        ByteBuffer bb = ByteBuffer.allocate(1024);
        //3.最后，需要将数据从通道读到缓冲区中，如下所示：
        channel.read(bb);
        byte[] bytes = bb.array();
        System.out.println(new String(bytes));
    }



}
