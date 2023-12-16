package com.fukuoka.unit2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Management management = new Management();
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("++++++++Quản lý Email+++++++");
            System.out.println("1. Thêm e-mail");
            System.out.println("2. Xem danh sách e-mail");
            System.out.println("3. Xóa danh sách e-mail");
            System.out.println("4. Kiểm tra e-mail");
            System.out.println("5. Sắp xếp e-mail");
            System.out.println("6. Đếm e-mail hợp lệ");
            System.out.println("7. Đếm e-mail không");
            System.out.println("8. Thoát");
            System.out.println("Mời bạn chọn :");
            int c = Integer.parseInt(sc.nextLine());
            switch (c) {
                case 1:
                    String select;
                    do {
                        System.out.println(management.add()?"Thêm thành công":"Thêm thất bại");;
                        System.out.println("Bạn có muốn nhập tiếp (Y/N)");
                        select = sc.nextLine();
                    } while (select.equalsIgnoreCase("y"));
                    break;
                case 2:
                    System.out.printf("%5s | %20s | %20s \n","ID","Tên chủ tài khoản","Email");
                    management.display();
                    break;
                case 3 :
                    System.out.println(management.delete()?"Xóa thành công":"Xóa thất bại");
                    break;
                case 4:
                    do {
                        System.out.println("Nhập ID của e-mail bạn muốn kiểm tra");
                        String id = sc.nextLine();
                        if (management.isExisted(id)){
                            for (Email e: management.getEmails()){
                                if (e.getId().equals(id)){
                                    System.out.println(management.check(e.getEmail())?"E-mail hợp lệ\n"+e.getEmail():"Email không hợp lệ\n"+e.getEmail());

                                    break;
                                }
                            }
                        }
                        System.out.println("Bạn có muốn nhập tiếp (Y/N)");
                        select = sc.nextLine();
                    } while(select.equalsIgnoreCase("y"));
                    break;
                case 5:
                    management.sort();
                    management.display();
                    break;
                case 6:
                    System.out.println("Số mail hợp lệ là: "+management.countCorrect());
                    break;
                case 7:
                    System.out.println("Số mail hợp lệ là: "+management.countIncorrect());
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn bạn không phù hợp");

            }

        } while (true);
    }
}
