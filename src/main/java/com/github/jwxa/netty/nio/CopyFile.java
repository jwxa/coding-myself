package com.github.jwxa.netty.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 标题<br>
 * User: Jwxa<br>
 * Date: 2016/9/27.
 */
public class CopyFile {

    public static void main(String[] args) throws IOException {
        String inFile = NioTest.class.getClassLoader().getResource("test.txt").getPath();
        String outFilePath  =  NioTest.class.getClassLoader().getResource("").getPath()+"testOut.txt";
        File outFile = new File(outFilePath);
        if(outFile.exists()){
            outFile.delete();
            outFile.createNewFile();
        }else{
            outFile.createNewFile();
        }
        FileInputStream fis = new FileInputStream(inFile);
        FileOutputStream fos = new FileOutputStream(outFile);
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true){
            // clear方法重设缓冲区，使它可以接受读入的数据
            buffer.clear();
            // 从输入通道中将数据读到缓冲区
            int i = inChannel.read(buffer);
            // read方法返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回-1
            if(i<0){
                break;
            }

            // flip方法让缓冲区可以将新读入的数据写入另一个通道
            buffer.flip();
            // 从输出通道中将数据写入缓冲区
            outChannel.write(buffer);

        }


    }
}
