package com.github.jwxa.designpattern.structural.composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 标题<br>
 * User: Jwxa<br>
 * Date: 2016/6/8.
 */
public class TreeNode {

    private String name;

    private TreeNode parent;

    private Vector<TreeNode> children =  new Vector<TreeNode>();

    public TreeNode(String name) {
        this.name = name;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    //添加孩子节点
    public void add(TreeNode treeNode){
        children.add(treeNode);
    }

    //删除孩子节点
    public void remove(TreeNode treeNode){
        children.remove(treeNode);
    }

    //取得孩子节点
    public Enumeration<TreeNode> getChildren(){
        return children.elements();
    }

}
