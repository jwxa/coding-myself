package com.github.jwxa.designpattern.behavioral.memonto;

import java.io.UnsupportedEncodingException;

/**
 * 备忘录模式<br>
 * 主要目的是保存一个对象的某个状态，以便在适当的时候恢复对象，个人觉得叫备份模式更形象些，通俗的讲下：假设有原始类A，A中有各种属性，A可以决定需要备份的属性，备忘录类B是用来存储A的一些内部状态，类C呢，就是一个用来存储备忘录的，且只能存储，不能修改等操作。<br>
 * User: Jwxa<br>
 * Date: 2016/6/15.
 */
public class Test {


    public static void main(String[] args) throws UnsupportedEncodingException {
        //创建原始类
        Original original = new Original("egg");
        //创建备忘录
        Storage storage = new Storage(original.createMemento());

        //修改原始类状态
        System.out.println("原来的值："+original.getValue());
        original.setValue("milk");
        System.out.println("修改后的值："+original.getValue());

        //回复原来状态
        System.out.println("-------回复原来状态------");
        original.restoreMemento(storage.getMemento());
        System.out.println("回复后的值："+original.getValue());


    }
}
