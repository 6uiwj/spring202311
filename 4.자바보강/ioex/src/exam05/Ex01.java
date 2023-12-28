package exam05;

import java.io.File;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) throws Exception {
        //File file = new File("D:/test1.txt");
        //file.createNewFile();
        //없는 디렉토리에 접근할 때
        //파일이 있는지 체크


       // File dir = new File("D:/forder");
        File dir = new File("D:/folder1/folder2/folder3");

        if (!dir.exists()) { //파일 또는 디렉토리 존재 유무
            dir.mkdir();
        }
       // File file = new File("D:/folder/test1.txt");
        File file = new File(dir, "test1.txt");
        //file.createNewFile();
        File file2 = File.createTempFile("tmp_",".log",new File("D:/"));
        Thread.sleep(3000);
        file2.deleteOnExit();
    }
}
