package exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLOutput;

public class Ex01 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("test1.txt")) {
            //반복을 통해 출력하고 -1이 나올 때까지 반복하면 됨
            int ch = 0;
            while((ch=fis.read()) != -1) {
                System.out.print((char)ch);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
