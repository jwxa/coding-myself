package com.github.jwxa.designpattern.structural.composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * ����<br>
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

    //��Ӻ��ӽڵ�
    public void add(TreeNode treeNode){
        children.add(treeNode);
    }

    //ɾ�����ӽڵ�
    public void remove(TreeNode treeNode){
        children.remove(treeNode);
    }

    //ȡ�ú��ӽڵ�
    public Enumeration<TreeNode> getChildren(){
        return children.elements();
    }

}
