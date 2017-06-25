package com.github.jwxa.netty.nio;

import java.nio.FloatBuffer;

/**
 * 使用 float 缓冲区。 <br>
 * User: Jwxa<br>
 * Date: 2016/9/26.
 */
public class UseFloatBuffer {

    public static void main(String[] args) {
        //分配一个容量为10的新的float缓冲区
        FloatBuffer buffer = FloatBuffer.allocate(10);
        for(int i =0;i<buffer.capacity();i++){
            float f = (float) (Math.sin(((float)i)/10)*(2*Math.PI));
            buffer.put(f);
        }
        buffer.flip();
        while(buffer.hasRemaining()){
            float f = buffer.get();
            System.out.println(f);
        }
    }


}
