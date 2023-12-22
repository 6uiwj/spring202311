package exam01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Ex03 {
    public static void main(String[] args) {
        //1에서 100까지 더하는 메서드...
        int total = IntStream.rangeClosed(1,100).sum();
        System.out.println(total);

        List<String> words = Arrays.asList("aa", "bb", "cc");
        //위의 문자를 한꺼번에 대문자로 바꾸기
        //스트림 내부에 구현된 반복문으로 반복처리
        List<String> words2 = words.stream().map(s-> s.toUpperCase()).toList();
        System.out.println(words2);
    }
}
