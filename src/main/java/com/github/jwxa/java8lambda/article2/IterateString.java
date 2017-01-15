package com.github.jwxa.java8lambda.article2;

/**
 * �ַ�������
 * <p>
 * ���������б�
 * </p>
 * User: Jwxa Date: 2017/1/15 ProjectName: coding-myself Version: 1.0
 */
public class IterateString {
    public static void main(String[] args) {
        final String str = "w00t";
        str.chars().forEach(ch-> System.out.println(ch));
        str.chars().forEach(System.out::println);
        //Java���������Զ��ؽ�Ŀ���ַ�����ÿһ���ַ���Ϊ�������뵽System.out.println�����С�
        // Ȼ��������Ϊ���ص�Stream��IntStream���ͣ����Դ�ӡ��������һ���������ֶ����������ڴ����ַ�������ʹ�����������ת����ȷ����ӡ�����ַ���
        str.chars().forEach(IterateString::printChar);
        //Ϊ�˽�����ֳ��������⣬IntStream�ṩ��һ��mapToObj��������ִ��Int���͵������������͵�ת��
        str.chars().mapToObj(a->Character.valueOf((char) a)).forEach(System.out::println);
        //��Ϊchars()���ص���Stream���ͣ������Ҳ���������Ŀ����ԣ�����ʹ��filter������
        str.chars().filter(Character::isDigit).forEach(IterateString::printChar);

    }



    public static void printChar(int aChar){
        System.out.println((char)aChar);
    }


}
