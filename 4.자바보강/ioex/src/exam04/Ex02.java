package exam04;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ex02 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("book.obj"); //멤버변수 데이터 존재
            //원래대로 복구해야 함
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            //ClassNotFoundException 발생가능
            Book b1 = (Book)ois.readObject();
            System.out.println(b1);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
