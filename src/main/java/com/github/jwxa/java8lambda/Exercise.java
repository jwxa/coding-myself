package com.github.jwxa.java8lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * http://lucida.me/blog/java-8-lambdas-insideout-language-features/
 * 融会贯通<br>
 * User: Jwxa<br>
 * Date: 2017/1/7.
 */
public class Exercise {

    public static void main(String[] args) {
        List<Person> people =  new ArrayList<>();
        people.add(new Person("cccc",11));
        people.add(new Person("aaaa",22));
        people.add(new Person("bbbb",33));
        //1.冗余代码实在太多了
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        //2.有了lambda表达式，我们可以去掉冗余的匿名类：
        Collections.sort(people, (Person x,Person y)->x.getName().compareTo(y.getName()));
        //3.尽管代码简洁了很多，但它的抽象程度依然很差 ：开发者仍然需要进行实际的比较操作（而且如果比较的值是原始类型那么情况会更糟），
        // 所以我们要借助 Comparator 里的 comparing 方法实现比较操作：
        Collections.sort(people, comparing((Person p) -> p.getName()));
        //4.在类型推导和静态导入的帮助下，我们可以进一步简化上面的代码：
        Collections.sort(people, comparing(p -> p.getName()));
        //5.我们注意到这里的 lambda 表达式实际上是 getLastName 的代理（forwarder），于是我们可以用方法引用代替它：
        Collections.sort(people, comparing(Person::getName));
        //6.最后，使用 Collections.sort 这样的辅助方法并不是一个好主意：
        // 它不但使代码变的冗余，也无法为实现 List 接口的数据结构提供特定（specialized）的高效实现
        // ，而且由于 Collections.sort 方法不属于 List 接口
        // ，用户在阅读 List 接口的文档时不会察觉在另外的 Collections 类中还有一个针对 List 接口的排序（sort()）方法。
        people.sort(comparing(Person::getName));
        //ex.此外，如果我们为 Comparator 接口增加一个默认方法 reversed()（产生一个逆序比较器），我们就可以非常容易的在前面代码的基础上实现降序排序。
        people.sort(comparing(Person::getName).reversed());
    }
}