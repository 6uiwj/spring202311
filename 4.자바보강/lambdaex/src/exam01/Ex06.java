package exam01;

import java.util.Arrays;

public class Ex06 {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40};
        Arrays.setAll(nums, x -> x * x);
        System.out.println((Arrays.toString(nums)));
    }
}
