package exam03;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex05 {
    public static void main(String[] args) {
        //다시 기본스트림으로 바꿔? 아니 집중해 이뇨속아!!!!
        try(FileInputStream fis = new FileInputStream("data.dat");
            DataInputStream dis = new DataInputStream(fis)) {
            //정확하게 순서대로 읽어야 됨!
            boolean result = dis.readBoolean();
            int num = dis.readInt();
            String str = dis.readUTF();

            System.out.printf("result=%s, num=%d, str=%s%n", result, num, str);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
