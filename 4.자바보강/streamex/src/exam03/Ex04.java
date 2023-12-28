package exam03;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex04 {
    public static void main(String[] args) {
        int[] nums = IntStream.iterate(1, x -> x + 2)
                .limit(10)
                .peek(System.out::println)
                .map(x -> x * x)
                .toArray();
        System.out.println(Arrays.toString(nums));
    }
}
