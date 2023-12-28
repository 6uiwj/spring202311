package exam;

public class C extends B {
    int numC = 30;

    public C() {
        super(); //상위 클래스 B의 생성자 메서드 B()
        System.out.println("C 생성자!");
    }
}
