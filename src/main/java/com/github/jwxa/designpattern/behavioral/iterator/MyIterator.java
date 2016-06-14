package com.github.jwxa.designpattern.behavioral.iterator;

/**
 * БъЬт<br>
 * User: Jwxa<br>
 * Date: 2016/6/14.
 */
public class MyIterator implements Iterator{

    private int pos = -1;

    private Collection collection;

    public MyIterator(MyCollection myCollection) {
        collection = myCollection;
    }


    public Object next() {
        if(pos<collection.size()-1){
            pos++;
        }
        return collection.get(pos);
    }

    public boolean hasNext() {
        if(pos<collection.size()-1){
            return  true;
        }else{
            return false;
        }
    }

    public Object previous() {
        if(pos>0){
            pos--;
        }
        return collection.get(pos);
    }

    public Object first() {
        pos = 0 ;
        return collection.get(0);
    }
}
