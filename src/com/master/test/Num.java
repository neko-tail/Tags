package com.master.test;

import java.util.Scanner;

public class Num {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        while (true) {
            int num = sc.nextInt();
            String numStr = num + "";
    
            String start = numStr.substring(0, 1);
            String content = numStr.substring(1, numStr.length() - 1);
            String end = numStr.substring(numStr.length() - 1, numStr.length());
    
            System.out.println(end + content + start);
            
            
            // int len = (int) Math.pow(10, (num + "").length() - 1);
            // int end = num % 10;
            // int start = num / len;
            // int content = num % len;
            //
            // int newNum = end * len + content - end + start;
            // System.out.println(newNum);
        }
        
    }
}
