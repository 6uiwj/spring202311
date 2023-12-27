package exam04;

import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ex01 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("book.obj");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
             Book b1 = new Book("책1", "저자1", "출판사1");

             oos.writeObject(b1);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
