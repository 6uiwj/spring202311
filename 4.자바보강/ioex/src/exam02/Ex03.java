package exam02;

import java.io.FileOutputStream;
import java.io.IOException;

public class Ex03 {
    public static void main(String[] args) {
        try(FileOutputStream for = new FileOutputStream("test3.txt")) {
            fos.write('안');
            fos.write('녕');
            fos.write('하');
            fos.write('세');
            fos.write('요');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
