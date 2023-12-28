package exam02;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private String publisher;


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }

    public Book(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author)
                && Objects.equals(publisher, book.publisher);
    }

    //같은 값에 대해 같은 해시코드가 나올 수 있게 정의됨
    @Override
    public int hashCode() {
        return Objects.hash(title, author, publisher);
    }
}
