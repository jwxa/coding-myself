package com.github.jwxa.java8lambda.article1;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * �������õ�����<br>
 * ��̬�������ã�ClassName::methodName
 * ʵ���ϵ�ʵ���������ã�instanceReference::methodName
 * �����ϵ�ʵ���������ã�super::methodName
 * �����ϵ�ʵ���������ã�ClassName::methodName
 * ���췽�����ã�Class::new
 * ���鹹�췽�����ã�TypeName[]::new
 * User: Jwxa<br>
 * Date: 2017/1/7.
 */
public class KindOfMethodReferences {


    public static void main(String[] args) {
        Consumer<Integer> b1 = System::exit;
        Consumer<String[]> b2 = Arrays::sort;
        Consumer<String[]> b3 = MyProgram::main;
        MyProgram myProgram = new MyProgram();
        Runnable r = myProgram::run;
        //------------------------------------------
        Set<String> knownNames = new TreeSet<>();
        knownNames.add("jwxa");
        Predicate<String> predicate = knownNames::contains;

        Set<String> allNames = new TreeSet<>();
        allNames.add("aaaaa");
        allNames.add("bbbbb");
//        allNames.add("jwxa");
        System.out.println(allNames.stream().anyMatch(predicate));


    }
}
class MyProgram implements Runnable{
    public static void main(String[] args) {

    }

    @Override
    public void run() {

    }
}