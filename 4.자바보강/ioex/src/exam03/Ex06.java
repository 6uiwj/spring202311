package exam03;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex06 {
    public static void main(String[] args) {
        //한개의 자료형을 가지고 하는 것이 좋다. (예측가능성)
        int[] scores = {90, 60, 70, 80, 100};

        try (FileOutputStream fos = new FileOutputStream("score.dat");
            DataOutputStream dos = new DataOutputStream(fos)) {
            for (int score: scores) {
                dos.writeInt(score);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
