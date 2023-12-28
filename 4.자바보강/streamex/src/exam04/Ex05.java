package exam04;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex05 {
    public static void main(String[] args) {
        //collect를 이용해 List를 set형태로 바꿔보자
        List<String> names = Arrays.asList("이름1", "이름1", "이름2", "이름3", "이름4");

        Set<String> names2 = names.stream().collect(Collectors.toSet());
        System.out.println(names2);

        //ArrayList<String> names3 = names.stream().collect(Collectors.toCollection(() -> new ArrayList<>()));
        //메서드 참조를 써서 짧게 만들자.
        ArrayList<String> names3 = names.stream().collect(Collectors.toCollection(ArrayList::new));
    }
}
