package com.github.jwxa.designpattern.behavioral.iterator;

/**
 * БъЬт<br>
 * User: Jwxa<br>
 * Date: 2016/6/14.
 */
public class MyCollection implements Collection {

    public String[] strings = {"A","B","C","D","E"};


    public Iterator iterator() {
        return new MyIterator(this);
    }

    public Object get(int i) {
        return strings[i];
    }

    public int size() {
        return strings.length;
    }
}
