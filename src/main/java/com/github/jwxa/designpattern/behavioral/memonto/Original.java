package com.github.jwxa.designpattern.behavioral.memonto;

/**
 * 原始类，里面有需要保存的属性value及创建一个备忘录类<br>
 * User: Jwxa<br>
 * Date: 2016/6/15.
 */
public class Original {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Original(String value) {
        this.value = value;
    }

    public Memento createMemento(){
        return new Memento(value);
    }

    public void restoreMemento(Memento memento){
        this.value = memento.getValue();
    }
}
