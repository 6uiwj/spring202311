package exam03;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex07 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //acc: 쌓여가는 형태(다음 return값이 누적되면서 쌓임)   //el:들어가는 요소? 1, 2, 3....
        int total = Arrays.stream(nums).reduce(0, (acc, el) -> {
            System.out.printf("acc=%d, el=%d%n", acc, el);
            //1-10까지 합계
           acc += el;
            return acc;
        });
        System.out.println(total);
    }
}
