package exam01;

public class Ex03 {
    public static void main(String[] args) {
        Calculator cal = x -> x * x;
        int result = cal.square(10);
        System.out.println(result);
    }
}
