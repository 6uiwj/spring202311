package exam04;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int total = Arrays.stream(nums).reduce(0,(acc, num) -> {
            System.out.printf("acc=%d, num=%d%n", acc, num);
           acc += num;

           return acc;
        });

            System.out.println(total);
        }
}

