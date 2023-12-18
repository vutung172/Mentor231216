package com.fukuoka.unit5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseManagement students = new CourseManagement();
        CourseManagement courses = new CourseManagement();
        do {
            System.out.println("+++++++Quản lý+++++++");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Thêm khóa học cho sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Thêm khóa học");
            System.out.println("6. Xóa khóa học");
            System.out.println("7. Hiển thị khóa học");
            System.out.println("8. Thoát");
            System.out.println("Lựa chọn của bạn là: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    String select;
                    do {
                        Student st = new Student();
                        st.input();
                        if (students.searchById(st.getId()) == null) {
                            students.add(st);
                            System.out.println("Thêm thành công");
                        } else {
                            System.out.println("ID học sinh đã tồn tại");
                        }
                        System.out.println("Bạn có muốn tiếp tục nhập không (Y/N): ");
                        select = sc.nextLine();
                    } while (select.equalsIgnoreCase("y"));
                    break;
                case 2:
                    do {
                        System.out.println("Nhập vào ID sinh viên muốn thêm course: ");
                        String id = sc.nextLine();
                        Student st = (Student) students.searchById(id);
                        if (st == null) {
                            System.out.println("Sinh viên không tồn tại");
                        } else {
                            System.out.printf("%5s | %15s | %10s | %10s | %15s | %15s |\n", "ID", "Tên sinh viên", "Tuổi", "Giới tính", "Số điện thoại", "Khóa học");
                            students.searchById(id).output();
                            if (st.getCourse() != null) {
                                System.out.println("Sinh viên đã có khóa học bạn có muốn cập nhật(Y/N): ");
                                String c = sc.nextLine();
                                if (c.equalsIgnoreCase("n"))
                                    break;
                            }
                            System.out.println("Nhập vào ID cousre muốn thêm: ");
                            String idCourse = sc.nextLine();
                            Course course = (Course) courses.searchById(idCourse);
                            if (course != null) {
                                students.addCourse(st, course);
                                System.err.println("Thêm course thành công");
                                break;
                            } else {
                                System.out.println("Khóa học không tồn tại");
                            }

                        }
                        System.out.println("Bạn có muốn tiếp tục nhập không (Y/N): ");
                        select = sc.nextLine();
                    } while (select.equalsIgnoreCase("y"));
                    break;
                case 3:
                    System.out.println("Nhập vào ID học sinh muốn xóa: ");
                    String id = sc.nextLine();
                    students.delete(students.searchById(id));
                    break;
                case 4:
                    System.out.printf("%5s | %15s | %10s | %10s | %15s | %15s |\n", "ID", "Tên sinh viên", "Tuổi", "Giới tính", "Số điện thoại", "Khóa học");
                    students.display();
                    break;
                case 5:
                    do {
                        Course course = new Course();
                        course.input();
                        if (courses.searchById(course.getId()) == null) {
                            courses.add(course);
                            System.out.println("Thêm thành công");
                        } else {
                            System.out.println("ID khóa học đã tồn tại");
                        }
                        System.out.println("Bạn có muốn tiếp tục nhập không (Y/N): ");
                        select = sc.nextLine();
                    } while (select.equalsIgnoreCase("y"));
                    break;
                case 6:
                    System.out.println("Nhập vào ID khóa học muốn xóa: ");
                    id = sc.nextLine();
                    courses.delete(courses.searchById(id));
                    break;
                case 7:
                    System.out.printf("%5s | %15s | %15s | %10s |\n", "ID", "Ten khóa học", "Giáo viên", "Sinh viên tối đa");
                    courses.display();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không phù hợp");
            }
        } while (true);
    }
}
