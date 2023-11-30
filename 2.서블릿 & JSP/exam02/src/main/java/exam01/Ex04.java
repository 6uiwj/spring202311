package exam01;

public class Ex04 {
    public static void main(String[] args) {
        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println(str1 == str2);
        System.out.println("equals : " + str1.equals(str2));
        System.out.println("str1.hashCode() : " + str1.hashCode());
        System.out.println("str2.hashCode() : " + str2.hashCode());

       // System.out.println("str1 : " + System.identityHashCode(str1));
       // System.out.println("str2: " + System.identityHashCode(str2));
    }
}
