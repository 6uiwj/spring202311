package exam01;

import java.io.FileOutputStream;
import java.io.IOException;

public class Ex03 {
    public static void main(String[] args) {
        //파일 경로를 입력하면 없는 파일이면 생성
        try (FileOutputStream fos = new FileOutputStream("test2.txt")) {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                fos.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
