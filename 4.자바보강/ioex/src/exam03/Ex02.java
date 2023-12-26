package exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        System.out.println("아무거나 입력 : ");
        //char ch = (char)System.in.read();
        InputStreamReader isr = new InputStreamReader(System.in); //변환기능 - 문자단위로 바뀌어서 한글이 깨지지 않음?
        BufferedReader br = new BufferedReader(isr);
        char ch = (char)br.read();
        //char ch = (char)System.in.read();
        //char ch = (char)isr.read();
        System.out.println(ch);

    }
}
