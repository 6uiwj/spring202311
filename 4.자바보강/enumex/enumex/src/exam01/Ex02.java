package exam01;

public class Ex02 {
    public static void main(String[] args) {
        String str = "TAXI";

        Transportation trans = Enum.valueOf(Transportation.class, str);
        System.out.println(trans);

        Transportation trans2 = Transportation.valueOf(str);
        System.out.println(trans==trans2);
    }
}
