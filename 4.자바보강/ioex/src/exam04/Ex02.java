package exam04;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public class Ex02 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("book.obj"); //멤버변수 데이터 존재
            //원래대로 복구해야 함
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            Map<String, Object> data = (Map<String, Object>) ois.readObject();

            String str = (String)data.get("str");
            Book b1 = (Book)data.get("book1");

            System.out.println(str);
            System.out.println(b1);
            /*
            //ClassNotFoundException 발생가능
            Book b1 = (Book)ois.readObject();
            System.out.println(b1);

            Book b2 = (Book)ois.readObject();
            System.out.println(b2);

            String str = (String)ois.readObject();
            System.out.println(str);

             */

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
