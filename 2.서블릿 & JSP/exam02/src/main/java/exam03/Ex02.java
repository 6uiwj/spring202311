package exam03;

public class Ex02 {
    public static void main(String[] args) {
        C c = new C(); // C -> C, B, A -> 다형성
        A a = c; // A -> A
        //B b = b; // A -> A, B
    }
}
