package exam01;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class Ex07 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("이름1", "이름2", "이름3");
        names.forEach(s -> System.out.println(s));
    }
}
