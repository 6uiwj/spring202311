package exam04;

public class Ex01 {
    public static void main(String[] args) {
        Student s1 = new Student(1000, "이름1", "과목1");
        System.out.println(s1);

        Student s2 = new Student(1001, "이름2", "과목2");
        System.out.println(s2);
        //주솟값이 복사가 된다.
        Student s3 = s2;
        s3.id = 1002;
        s3.name= "이름3";
        s3.subject = "과목3";
        System.out.println(s3);
        System.out.println(s2);
        //참조가 끊김 (주소가 사라짐)
        s1= null;

    }
}
