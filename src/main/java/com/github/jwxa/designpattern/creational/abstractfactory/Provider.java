package com.github.jwxa.designpattern.creational.abstractfactory;

import com.github.jwxa.designpattern.creational.factory.normalfactory.normal.Sender;

/**
 * БъЬт
 * User: Jwxa
 * Date: 2016/4/11.
 */
public interface Provider {
    public Sender produce();
}
