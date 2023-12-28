package exam01;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class Ex05 {
    public static void main(String[] args) {
        //BiFunction<Integer, Integer, Integer> func = (a,b) -> a + b;
        //BinaryOperator<Integer> func = (a,b) -> a + b;
        IntBinaryOperator func = (a,b) -> a + b;
       // int result = func.apply(10,20);
        int result = func.applyAsInt(10, 20);
        System.out.println(result);
    }
}
