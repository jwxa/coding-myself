package com.github.jwxa.algorithms;

/**
 * БъЬт
 * User: Jwxa
 * Date: 2016/3/23.
 */
public class Exercise1 {

    public static void main(String[] args) {
//        System.out.println(getOneNum(6) + "");
        Exercise1 permute = new Exercise1();
        permute.permute("abc");
    }


    public static int getOneNum(int num) {
        if (num == 1) {
            return 1;
        }

        if (num % 2 != 0) {
            return getOneNum(num / 2) + 1;
        } else {
            return getOneNum(num / 2);
        }
    }


    public void permute(String str) {
        permute(str.toCharArray(), 0, str.length()-1);
    }

    public  void permute(char[] list, int low, int high) {
        int i;
        if (low == high) {
            String cout = "";
            for (i = 0; i <= high; i++)
                cout += list[i];
            System.out.println(cout);
        } else {
            for (i = low; i <= high; i++) {
                char temp = list[low];
                list[low] = list[i];
                list[i] = temp;
                permute(list, low + 1, high);
                temp = list[low];
                list[low] = list[i];
                list[i] = temp;
            }
        }
    }

}