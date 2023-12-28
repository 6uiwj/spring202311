package exam03;

import java.util.Arrays;

public class Ex06 {
    public static void main(String[] args) {
        String[] strs = { "aa", "aaa", "bbb", "ccc"};
        //전부 참이어야 참
        boolean result1 = Arrays.stream(strs).allMatch(s -> s.length() >= 3);
        System.out.println(result1);

        //한개라도 맞는 값이 있으면 참
        boolean result2 = Arrays.stream(strs).anyMatch(s -> s.length() >= 3);
        System.out.println(result2);
    }
}
