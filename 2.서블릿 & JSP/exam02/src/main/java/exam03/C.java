package exam03;

public class C extends B{
    int numC = 30;

    public C(){
        super(); // 상위클래스 객체의 기본생성자 -> 정의하지 않아도 추가돼!! 왜냐구? 필수니까!
        System.out.println("C 생성자!");
    }
}
