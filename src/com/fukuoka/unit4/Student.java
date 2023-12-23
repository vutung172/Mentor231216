package com.fukuoka.unit4;

import com.fukuoka.unit5.Course;

import java.util.List;
import java.util.Scanner;

public class Student implements IBase {
    private String id;
    private String name;
    private int age;
    private String className;
    private float avg;
    private List<Subject> subjects;
    private boolean isStudent = true;


    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào id: ");
        id = sc.nextLine();
        System.out.println("Nhập vào tên: ");
        name = sc.nextLine();
        System.out.println("Nhập vào tuổi: ");
        age = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập vào tên lớp: ");
        className = sc.nextLine();
    }

    @Override
    public void output() {
        if (subjects == null){
            System.out.printf("%5s | %15s | %10s | %10s | %15s | %15s |\n",id,name,age,className,avg,"Chưa xếp lớp");
        }else {
        System.out.printf("%5s | %15s | %10s | %10s | %15s |\n",id,name,age,className,avg);}
    }

    @Override
    public boolean checkId(String id) {
        boolean check = id.equals(this.id);
        return check;
    }
}
