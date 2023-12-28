package exam03;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex09 {
    public static void main(String[] args) {
        //총 3명의 저자가 나누가짐 (0, 1, 2)
        List<Book> books = IntStream.rangeClosed(1, 20)
                .mapToObj(i -> new Book("책" + i, "저자" + (i%3), "출판사" + i)).
                toList();

        //books.forEach(System.out::println);
        //직접 그룹핑을 가지고 값을 나눠준다.
        Map<String, List<Book>> books2 = books.stream().collect(Collectors.groupingBy(Book::getAuthor));

        List<Book> books3 = books2.get("저자1");
        books3.forEach(System.out::println);
    }
}
