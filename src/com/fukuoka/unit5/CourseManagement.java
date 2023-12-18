package com.fukuoka.unit5;

import java.util.Arrays;
import java.util.Scanner;

public class CourseManagement {
    private IBase[] iBases;

    private int index = 0;

    private int defaultEmelent = 4;


    public CourseManagement() {
        this.iBases = new IBase[defaultEmelent];
    }

    public IBase[] getiBases() {
        return iBases;
    }

    public int getIndex() {
        return index;
    }


    public void add(IBase iBase) {
        if (index == iBases.length - 1)
            iBases = Arrays.copyOf(iBases, iBases.length + defaultEmelent);
        iBases[index++] = iBase;
}


    public void delete(IBase iBase) {
        for (int i = 0; i < index; i++) {
            if (iBases[0] != null) {
                if (iBases[i].equals(iBase)) {
                    for (int j = i; j < index - 1; j++) {
                        iBases[j] = iBases[j + 1];
                    }
                    iBases[index] = null;
                    index -= 1;
                    System.out.println("Xóa thành công");
                    break;
                }
                System.out.println("Xóa thất bại");
            }
        }

    }


    public void display() {
        for (int i = 0; i < index; i++) {
            iBases[i].output();
        }
    }

    public IBase searchById(String id) {
        for (int i = 0; i < index; i++) {
            if (iBases[i].checkId(id)) {
                return iBases[i];
            }
        }
        return null;
    }


    public void addCourse(Student st, Course course){
        st.setCourse(course);
    }
}

