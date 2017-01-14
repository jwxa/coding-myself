package com.github.jwxa.java8lambda.article1;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 方法引用的种类<br>
 * 静态方法引用：ClassName::methodName
 * 实例上的实例方法引用：instanceReference::methodName
 * 超类上的实例方法引用：super::methodName
 * 类型上的实例方法引用：ClassName::methodName
 * 构造方法引用：Class::new
 * 数组构造方法引用：TypeName[]::new
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