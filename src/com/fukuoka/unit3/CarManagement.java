package com.fukuoka.unit3;

import java.util.Scanner;

public class CarManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car car = new Car("Audi","Yelow",15800);
        do {
            System.out.println("*******Quản lý ô tô*******");
            System.out.println("1. Bật động cơ");
            System.out.println("2. Tắt động cơ");
            System.out.println("3. Tăng tốc");
            System.out.println("4. Giảm tốc");
            System.out.println("5. Hiện thông tin xe");
            System.out.println("6. Thoát");
            System.out.println("Mời bạn chọn");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    car.start();
                    break;
                case 2:
                    car.stop();
                    break;
                case 3:
                    car.acceleration();
                    break;
                case 4:
                    car.deceleration();
                    break;
                case 5:
                    System.out.printf("Hãng xe: %s | Màu xe: %s | Giá tiền: %s USD | Trạng thái động cơ: %s | Tốc Độ: %s | Trạng thái đèn: %s |\n",car.getBrand(),car.getColor(),car.getPrice(),car.isEngineStatus()?"Động cơ đang bật":"Động cơ đã tắt",car.getSpeed(),car.isLightStatus()?"Đèn đang bật":"Đèn đã tắt");
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không phù hợp");
            }
        } while(true);
    }
}
