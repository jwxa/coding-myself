package com.github.jwxa.jvm.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * Java∂—ƒ⁄¥Ê“Á≥ˆ“Ï≥£≤‚ ‘
 * VM Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * User: Jwxa Date: 2017/4/10 ProjectName: coding-myself Version: 1.0
 */
public class HeapOOM {

    static class OOMObject{

        public static void main(String[] args) {
            List<OOMObject> list = new ArrayList<>();
            while(true){
                list.add(new OOMObject());
            }
        }

    }
}
