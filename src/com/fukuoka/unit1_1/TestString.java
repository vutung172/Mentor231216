package com.fukuoka.unit1_1;

import java.util.Scanner;

public class TestString {
    public static void main(String[] args) {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Mời bạn nhập vào chuỗi");
            String s = sc.nextLine();
            findLargesSubstring(s);
        } while(true);

    }
    public static boolean check(String s){
      char[] chars = s.toCharArray();
      for (int i =0; i < chars.length; i++){
        char c = chars[i];
        for (int j = i; j < chars.length-1; j++){
            if (chars[j+1] == c){
                return true;
            }
        }
      }
      return false;
    }

    public static void findLargesSubstring(String s){
        char[] chars = s.toCharArray();
        String largestString = String.valueOf(chars[0]);
        for (int i = 0; i < chars.length; i++){
            char c = chars[i];
            String tempString = String.valueOf(c);
            for (int j = i+1; j < chars.length; j++){
                String string = tempString + chars[j];
                if (!check(string)){
                    tempString = string;
                }
            }
            if (tempString.length() > largestString.length()){
                largestString = tempString;
            }
        }
        System.out.println("Chuỗi lớn nhất là: " +largestString);

    }
}
