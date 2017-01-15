package com.github.jwxa.java8lambda.article2;

/**
 * 字符串遍历
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/15 ProjectName: coding-myself Version: 1.0
 */
public class IterateString {
    public static void main(String[] args) {
        final String str = "w00t";
        str.chars().forEach(ch-> System.out.println(ch));
        str.chars().forEach(System.out::println);
        //Java编译器会自动地将目标字符串的每一个字符作为参数传入到System.out.println方法中。
        // 然而正是因为返回的Stream是IntStream类型，所以打印出来的是一个个的数字而不是我们期待的字符。可以使用下面的类型转换来确保打印的是字符：
        str.chars().forEach(IterateString::printChar);
        //为了解决这种常见的问题，IntStream提供了一个mapToObj方法用来执行Int类型到其它任意类型的转换
        str.chars().mapToObj(a->Character.valueOf((char) a)).forEach(System.out::println);
        //因为chars()返回的是Stream类型，因此它也开启了诸多的可能性，比如使用filter方法：
        str.chars().filter(Character::isDigit).forEach(IterateString::printChar);

    }



    public static void printChar(int aChar){
        System.out.println((char)aChar);
    }


}
