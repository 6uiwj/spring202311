package exam04;

import java.io.Serializable;

public class Book implements Serializable {
    public static final long serialVersionUID = 1L;
    private String title;
    private String author;
    private String publisher;

    private String str;
    private String str2;

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
}
