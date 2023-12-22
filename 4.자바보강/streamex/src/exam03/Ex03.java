package exam03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ex03 {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("책3", "저자3", "출판사3"),
                new Book("책4", "저자4", "출판사4"),
                new Book("책1", "저자1", "출판사1"),
                new Book("책2", "저자2", "출판사2"),
                new Book("책2", "저자2", "출판사2"),
                new Book("책5", "저자5", "출판사5")

        );

        //books.stream().distinct().sorted((b1,b2) -> b1.getTitle().compareTo(b2.getTitle())).forEach(System.out::println);
        books.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);

    }
}
