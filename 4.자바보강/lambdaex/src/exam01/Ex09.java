package exam01;

import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;

public class Ex09 {
    public static void main(String[] args) {
        IntPredicate cond1 = x -> x >= 10;
        IntPredicate cond2 = x -> x <= 100;

        //두 조건 결합하기 10 <= x <= 100 : and 이용
        IntPredicate cond3 = cond1.and(cond2);
        //부정
        IntPredicate cond4 = cond2.negate(); // x > 100

        System.out.println("cond3 : " + cond3.test(150));
        System.out.println("cond4 : " + cond4.test(150));
    }
}
