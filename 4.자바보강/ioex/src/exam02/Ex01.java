package exam02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//읽어와서 쓰기
public class Ex01 { //1byte씩 출력하는 예제
    //시작시간 기록
    public static void main(String[] args) {
        long stime = System.currentTimeMillis();

        try (FileInputStream fis = new FileInputStream("specs.zip");
             FileOutputStream fos = new FileOutputStream("specs_copied.zip")) {

            while(fis.available() > 0 ) {
                fos.write(fis.read());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //끝 시간 기록
        long etime = System.currentTimeMillis();
        //시간 기록
        System.out.printf("걸린 시간: %d%n", etime -stime);
    }
}
