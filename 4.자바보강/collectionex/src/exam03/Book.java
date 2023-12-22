package exam03;

import java.util.Comparator;
import java.util.Objects;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private String publisher;

    public Book(String title, String author, String publisher) {
        this.title = title;
        this. author = author;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(publisher, book.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publisher);
    }


    @Override
    public int compareTo(Book o) {
        //현재 대상 - 비교 대상 : 오름차순
        //비교 대상 - 현재 대상 : 내림차순
        //return title.hashCode() - o.title.hashCode(); - 오름차순
       // return o.title.hashCode() - title.hashCode(); //내림차순
        //return title.compareTo(o.title); //오름차순
        //return o.title.compareTo(title); //내림차순
        return title.compareTo(o.title) * -1;
    }
}
