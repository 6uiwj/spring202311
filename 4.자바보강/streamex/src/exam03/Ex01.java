package exam03;

import java.util.stream.IntStream;

public class Ex01 {
    public static void main(String[] args) {
        //5개를 건너뛸랭!!!
        IntStream.rangeClosed(1,10).skip(5).forEach(System.out::println);
    }
}
