package exam01;

import java.util.Arrays;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        String[] words = { "aaa", "aaa", "bb", "cc", "abcd", "abcd" };
        //배열을 스트림 객체로 바꿔보자 - arrays 객체에서 가져옴
        //스트림을 사용하여 중복은 제거하고, 3자 이상인 것만 뽑아보자
        Arrays.stream(words)
                .distinct().filter(s -> s.length() >= 3)
                .forEach(System.out::println);
        //List로 해보자
        List<String> words2 = Arrays.asList("aaa", "aaa", "bb", "cc", "abcd", "abcd");
        words2.stream()
                .distinct().filter(s -> s.length() >=3)
                .forEach(System.out::println);
    }

}
