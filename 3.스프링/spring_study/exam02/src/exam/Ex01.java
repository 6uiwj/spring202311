package exam;

public class Ex01 {
    public static void main(String[] args) {
        //생성자 함수(메서드) - 객체를 생성하는 역할(힙 메모리에 필요한 자원을 위한 공간 할당)
        C c = new C(); //C, B, A
        A a = c; //A객체에 c를 담아도 포도주우우우스
        B b = c; //B에다가 c를 담아도 포도주우우우우스

        A a2 = new C();

    }
}
