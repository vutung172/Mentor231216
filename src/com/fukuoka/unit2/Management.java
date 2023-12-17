package com.fukuoka.unit2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Management implements IManagement{
    private Email[] emails;
    private int index =0;
    private int defaultElement =4;


    public Email[] getEmails() {
        return emails;
    }

    public Management() {
        this.emails = new Email[defaultElement];
    }


    @Override
    public boolean add() {
        Email email = new Email();
        email.input();
        if (!isExisted(email.getId())){
            if(index == emails.length-1)
                emails = Arrays.copyOf(emails,emails.length + defaultElement);
            emails[index++] = email;
            return true;
        }
        return false;
    }
    public boolean isExisted(String id){
        for (int i = 0; i < index;i++){
            if (emails[i].getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete() {
        Scanner sc = new Scanner(System.in);
        Email email = new Email();
        System.out.println("Nhập ID e-mail muốn xóa:");
        String id = sc.nextLine();
        if (!isExisted(id)){
            System.out.println("ID của E-mail cần xóa không tồn tại");
            return false;
        } else {
            for (int i = 0; i < index; i++){
                if (emails[i].getId().equals(id)){
                    for (int j = i ; j < index-1; j++){
                        emails[j] = emails[j+1];
                    }
                    emails[index] = null;
                    index = index - 1;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void display() {
        for (int i = 0; i < index; i++){
            emails[i].output();
        }
    }

    @Override
    public boolean check() {
        return false;
    }

    public boolean check(String email){
        Pattern p = Pattern.compile(".*@.*(com|.jp|.vn)");
        Matcher m = p.matcher(email);
        return m.matches();
    }


    @Override
    public void sort() {
        System.out.println("Chọn loại muốn sắp xếp");
        System.out.println("1. Tăng dần");
        System.out.println("2. Giảm dần");
        Scanner sc = new Scanner(System.in);
        int c = Integer.parseInt(sc.nextLine());
        switch (c){
            case 1:
                sortByIncrease();
                break;
            case 2:
                sortByDecrease();
                break;
        }


    }

    public void sortByIncrease(){
        for (int i = 0; i < index; i++){
            for (int j = i+1; j < index;j ++) {
                if (emails[i].getEmail().compareTo(emails[j].getEmail()) > 0) {
                    Email temp = emails[i];
                    emails[i] = emails[j];
                    emails[j] = temp;
                }
            }
        }
    }

    public void sortByDecrease(){
        for (int i = 0; i < index; i++){
            for (int j = i+1; j < index;j ++) {
                if (emails[i].getEmail().compareTo(emails[j].getEmail()) < 0) {
                    Email temp = emails[i];
                    emails[i] = emails[j];
                    emails[j] = temp;
                }
            }
        }
    }

    @Override
    public int count() {
        return 0;
    }

    public int countCorrect(){
        int count = 0;
        for(int i = 0; i < index; i++){
            if (check(emails[i].getEmail())){
                count++;
            }
        }
        return count;
    }

    public int countIncorrect(){
        int count = 0;
        for(int i = 0; i < index; i++){
            if (!check(emails[i].getEmail())){
                count++;
            }
        }
        return count;
    }
}
