package exam02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex05 {
    public static void main(String[] args) {
        //특정 연산식을가지고(x -> x+2) 계속 증가하면서 iterate을 만듦? 10개까지(limint(10)), 배열로 반환(toArray();)
        int[] nums = IntStream.iterate(10, x-> x+2).limit(10)
                .toArray();
        System.out.println(Arrays.toString(nums));


        int[] nums2 = IntStream.generate(()->1).limit(10).toArray();
        System.out.println(Arrays.toString(nums2));
    }
}
