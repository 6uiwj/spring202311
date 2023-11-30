package exam02;

import java.awt.*;

public class Ex01
{
    public static void main(String[] args) {
        Student s1 = new Student(1000,"이름1","과목1");
        s1.setName("이름2");
        System.out.println(System.identityHashCode(s1));

        Student s2 = s1;
        s2.setId(1001);
        s2.setName("이름2");
        System.out.println("s2:" + s2);
        System.out.println("s1:" + s1);




    }
}
