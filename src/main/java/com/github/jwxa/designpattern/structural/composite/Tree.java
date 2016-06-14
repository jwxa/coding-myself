package com.github.jwxa.designpattern.structural.composite;

/**
 * ���ģʽ
 * ��ʱ�ֽв���-����ģʽ
 * �ڴ����������νṹ������ʱ�ȽϷ���<br>
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
