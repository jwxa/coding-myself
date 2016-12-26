package com.github.jwxa.thinkinginjava.chapter5;

/**
 * 终结条件：示范finalize()可能的使用方式
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/12/24 ProjectName: coding-myself Version: 1.0
 */
public class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);
        //Proper cleanup:
        novel.checkIn();
        //Drop the reference , forget to clean up:
        new Book(true);
        //Force garbage collection & finalization:
        System.gc();
    }

}
class Book{
    boolean checkedOut = false;
    Book(boolean checkOut){
        checkedOut = checkOut;
    }
    void checkIn(){
        checkedOut =false;
    }

    protected  void finalize(){
        if(checkedOut)
            System.out.println("Error: checked out");
        //Normally,you'll also do this:
        //super.finalize();//Call the base-class version
    }
}



