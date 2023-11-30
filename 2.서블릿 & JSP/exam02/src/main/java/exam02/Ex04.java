package exam02;

import java.util.HashSet;

public class Ex04 {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<>();
        students.add(new Student(1000, "학생1","과목1"));
        students.add(new Student(2000, "학생2","과목2"));
        students.add(new Student(2000, "학생2","과목2"));
        students.add(new Student(3000, "학생3","과목3"));
        students.add(new Student(4000, "학생1","과목4"));
        students.add(new Student(5000, "학생5","과목5"));

        for(Student s : students) {
            System.out.println(s);
        }
    }
}
