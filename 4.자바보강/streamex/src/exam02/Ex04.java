package exam02;

import java.util.Random;

public class Ex04 {
    public static void main(String[] args) {
        Random rand = new Random();
        //limit : 스트림 데이터 중 개수를 짤라줌
        //rand.ints().limit(10).forEach(System.out::println);
        rand.ints(10).forEach(System.out::println);
    }
}
