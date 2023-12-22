package exam01;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Ex11 {
    public static void main(String[] args) {
        //Supplier<Book> book = () -> new Book();
        Supplier<Book> book = Book::new;

        List<String> names = Arrays.asList("이름", "이름2", "이름3");
        //요소의 개수가 넘어옴(=3)
        //리스트에서 넘어온 게 String 배열로 바뀌어 넘어간다.
        //String[] names2 = names.stream().toArray(i->new String[i]);
        //더 짧게 써 보자.
        String[] names2 = names.stream().toArray(String[]::new);
    }
}
