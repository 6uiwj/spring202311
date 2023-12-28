package exam01;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

public class Ex10 {
    public static void main(String[] args) {
        //Consumer<String> func1 = s -> System.out.println(s);
        //더 짧게 써 보자.
        // :: -> 메서드를 참조한다.
        Consumer<String> func1 = System.out::println;

        //문자열의 길이를 구해보자
        //Function<String, Integer> func2 = s -> s.length();
        Function<String, Integer> func2 = String::length;

        //문자열2개를 매개변수로 받고, 반환값으로 맞냐 틀리냐를 출력해보자
        //s1, s2의 순서가 동일할 때만 축약해서 쓸 수 있다..!
        //(s1, s2) -> s2.equals(s1);은 불가넝
        //BiPredicate<String, String> func3 = (s1, s2) -> s1.equals(s2);
        BiPredicate<String, String> func3 = String::equals;

    }
}
