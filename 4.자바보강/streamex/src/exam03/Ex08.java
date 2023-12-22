package exam03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

public class Ex08 {
    public static void main(String[] args) {
        //mapToObj : int -> 다른 일반스트림으로 바꿀 수 있는 기능
        //for문을 쓰지 않고 책10권 추가해보자
        List<Book> books = IntStream.rangeClosed(1, 10).mapToObj(i -> new Book("책" + i, "저자" + i, "출판사" + i)).toList();
        //메서드 참조이용
        Map<String, String> data = books.stream().collect(toMap(Book::getAuthor, Book::getTitle  ));
                //값을 전부 조회하고 싶을 때에는 map의 entryset를 사용하면 좋다.

        data.entrySet().stream().forEach(e -> System.out.printf("key=%s, value=%s%n", e.getKey(), e.getValue()));
    }
}
