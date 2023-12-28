package exam04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex06 {
    //콤마로 묶여서 하나의 문자열로 출력된다.
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Orange", "Mange", "Melon");
        String str = fruits.stream().collect(Collectors.joining(","));
        System.out.println(str);
    }
}
