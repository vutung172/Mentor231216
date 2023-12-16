package com.fukuoka.unit1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập vào số La Mã: ");
            String num  = sc.nextLine();
            char[] chars = num.toCharArray();

            SoLaMa soLaMa = new SoLaMa() {
                @Override
                public void tranfer() {
                    int sum = 0;
                    for (int i = 0; i < chars.length; i++){
                        switch (chars[i]){
                            case 'I' :
                                if (chars[i] != chars[i+1]){
                                    sum = sum -1;
                                } else {
                                sum = sum + 1;}
                                break;
                            case 'V':
                                sum = sum + V;
                                break;
                            case 'X':
                                sum = sum + X;
                                break;
                            case 'L':
                                sum = sum + L;
                                break;
                            case 'C':
                                sum  =sum + C;
                                break;
                            case 'D':
                                sum = sum + D;
                                break;
                            case 'M':
                                sum = sum + M;
                                break;
                            default:
                                System.out.println("Kí tự bạn chọn không phải số la mã");
                        }
                    }
                    System.out.println("Số nguyên được chuyển từ số la mã  là: "+sum);
                }
            };
            soLaMa.tranfer();
        } while (true);
    }
    public static int check(char[] chars){
        for (int i = 0; i < chars.length; i ++){

        }return 1;
    }
}
