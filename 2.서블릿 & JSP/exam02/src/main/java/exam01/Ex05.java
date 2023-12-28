package exam01;

public class Ex05 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2);

        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));

        int num1 = 10; //literal 상수
        int num2 = 10; //둘의 값 공유
        System.out.println(num1 == num2);
    }
}
