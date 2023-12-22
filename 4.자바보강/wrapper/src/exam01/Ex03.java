package exam01;

public class Ex03 {
    public static void main(String[] args) {
        int num1 = 100;
        Integer num2 = new Integer(200);

        int num3 = num1 + num2; //num2.intValue() - 컴파일러에서 자동 추가
        System.out.println(num3);

        //자료형이 다른데 어떻게 대입이 돼?
        //이렇게 많이 쓰니까 편의상 변환이 추가된 거야...
        //Integer.valueOf(num3) <-컴파일러가 이걸 자동 추가한거야
        Integer num4 = num3;
    }
}
