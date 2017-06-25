package com.github.jwxa.netty.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * http://zhangshixi.iteye.com/blog/679959<br>
 * User: Jwxa<br>
 * Date: 2016/9/26.
 */
public class NioStudy {


    /**
     * 使用IO读取指定文件的前1024个字节的内容。
     * @param file 指定文件名称。
     * @throws IOException IO异常。
     */
    public void ioRead(String file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] b = new byte[1024];
        fis.read(b);
        System.out.println(new String(b));
    }

    /**
     * 使用NIO读取指定文件的前1024个字节的内容。
     * @param file 指定文件名称。
     * @throws IOException IO异常。
     */
    public void nioRead(String file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        FileChannel channel = fis.getChannel();
        ByteBuffer bb = ByteBuffer.allocate(1024);
        channel.read(bb);
        byte[] b = bb.array();
        System.out.println(new String(b));
    }


}
