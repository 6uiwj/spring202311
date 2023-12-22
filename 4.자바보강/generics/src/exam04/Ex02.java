package exam04;

import java.sql.Struct;

public class Ex02 {
    public static void main(String[] args) {
        Student s1 = new Student(1000, "이름1", "과목1");
        Student s2 = new Student(1001, "이름2", "과목2");

        System.out.println(s1);
        System.out.println(s2);
    }
}
