package exam02;

import java.util.stream.IntStream;

public class Ex03 {
    public static void main(String[] args) {
        //끝엔 포함되지 않기 때문에 10번 반복될 것 [0,10) 범위
        //for 문을 사용하지 않고 반복
        IntStream.range(0, 10).forEach(i -> System.out.println("반복"));

        //1~100까지 합계 구하기
        //[1,100]범위
        int total = IntStream.rangeClosed(1,100).sum();
        System.out.println(total);
    }
}
