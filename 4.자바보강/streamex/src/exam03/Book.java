package exam03;


import java.util.Objects;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private String publisher;

    public Book(){}


    public Book(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
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
        return Objects.equals(title, book.title) && Objects.equals(author, book.author)
                && Objects.equals(publisher, book.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publisher);
    }

    //내림차순 정렬하기
    //비교대상에서 현재 대상을 비교..???
    //앞에꺼가 현재대상이면 오름차순
    //앞에꺼가 비교대상이면 내림차순..??
    @Override
    public int compareTo(Book o) {
        return o.title.compareTo(title);
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() { return author; }
}
