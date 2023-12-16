package com.fukuoka.unit2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email implements IEmail{
    private String id;
    private String name;
    private String email;

    public Email() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào ID:");
        id = sc.nextLine();
        System.out.println("Nhập vào tên: ");
        name = sc.nextLine();
        System.out.println("Nhập vào E-mail");
        email = sc.nextLine();
    }

    @Override
    public void output() {
        System.out.printf("%5s | %20s | %20s \n",id,name,email);
    }



}
