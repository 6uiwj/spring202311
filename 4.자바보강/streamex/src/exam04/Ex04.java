package exam04;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class Ex04 {
    public static void main(String[] args) {
        int[] nums = {22, 10, 5, 99, 17};
        //BinaryOperator가 매개변수, 반환값이 optional일 때 예제!
        OptionalInt opt = Arrays.stream(nums).reduce((acc,num) -> {
            System.out.printf("acc=%d, num=%d%n", acc, num);

            acc += num;
            return acc;
        });

        int total = opt.getAsInt();
        System.out.println(total);
    }
}
