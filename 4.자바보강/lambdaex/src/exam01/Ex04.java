package exam01;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class Ex04 {
    public static void main(String[] args) {
        //Function<Integer, Integer> func = x -> x * x;
        //UnaryOperator<Integer> func = x -> x * x;
        //이게 성능이 제일 좋음, 기본 자료형이라서 변환이 필요없음
        IntUnaryOperator func = x -> x * x;
       // int result = func.apply(100);
        int result = func.applyAsInt(100);
        System.out.println(result);
    }
}
