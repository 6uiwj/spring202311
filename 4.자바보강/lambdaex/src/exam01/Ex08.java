package exam01;

import java.util.function.Function;

public class Ex08 {
    public static void main(String[] args) {
        //문자가 들어오면 문자의 길이를 반환
        Function<String, Integer> func1 = s -> s.length();
        //숫자가 들어오면 숫자를 세제곱
        Function<Integer, Integer> func2 = x -> x * x * x;

        //문자가 들어오면 길이를 계산하고 이 길이를 세제곱하도록 결합시키자.
        Function<String, Integer> func3 = func1.andThen(func2);
        // = func2.compose(func1)

        int num = func3.apply("ABC");
        System.out.println(num);

        //항등함수
        Function<Integer, Integer> func4 =  x -> x;
        //위와 같음
        Function<Integer, Integer> func5 = Function.identity();
    }
}
