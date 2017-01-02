package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 增强for循环
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/1/3 ProjectName: coding-myself Version: 1.0
 */
public class DynamicArray {

    public static void main(String[] args) {
        Other.main(new String []{"fiddle","de","dum"});
    }
}
class Other{
    public static void main(String[] args) {
        for(String s:args){
            System.out.println(s+" ");
        }
    }
}