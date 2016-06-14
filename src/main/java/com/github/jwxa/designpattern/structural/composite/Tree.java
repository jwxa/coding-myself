package com.github.jwxa.designpattern.structural.composite;

/**
 * 组合模式
 * 有时又叫部分-整体模式
 * 在处理类似树形结构的问题时比较方便<br>
 * User: Jwxa<br>
 * Date: 2016/6/13.
 */
public class Tree {

    TreeNode root = null;


    public Tree(String name){
        root = new TreeNode(name);
    }


    public static void main(String[] args) {
        Tree tree = new Tree("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");

        nodeB.add(nodeC);
        tree.root.add(nodeB);
        System.out.println("build the tree finished!");
        tree.root.getChildren();
    }


}
