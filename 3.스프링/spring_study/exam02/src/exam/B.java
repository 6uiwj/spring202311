package exam;

public class B extends A {
    int numB = 20;

    public B() {
        super(); //A() 호출
        System.out.println("B 생성자!");
    }
}
