package exam03;

import java.util.Optional;

public class Ex05 {
    public static void main(String[] args) {
        Optional<Book> book = Optional.ofNullable(null);
        //Book b1 = new Book();
        //Book b = book.orElse(b1); 더 간단하게 써보자
        //Book b = book.orElseGet(() -> new Book()); 람다식을 써서 더..더...짧게...
        Book b = book.orElseGet(Book::new);
    }
}
