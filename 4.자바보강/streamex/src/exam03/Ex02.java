package exam03;

import java.util.stream.IntStream;

public class Ex02 {
    //1부터 100까지 중 홀수만 더해보자
    public static void main(String[] args) {
        //판별식을 넣고 참인 것만 걸러줌
        int total = IntStream.rangeClosed(1, 100).filter(x -> x % 2 ==1).sum();
        System.out.println(total);
    }
}
