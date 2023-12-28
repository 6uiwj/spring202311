package exam04;

import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        int[] nums = { 22, 10, 5, 99, 17};
        //최솟값 구하기
        int min = Arrays.stream(nums).reduce(Integer.MAX_VALUE, (a,b) -> a > b ? b : a );
        System.out.println(min);
    }
}
