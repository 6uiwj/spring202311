package exam01;

import java.util.LinkedList;
import java.util.Queue;

public class Ex07 {
    public static void main(String[] args) {
        Queue<String> names = new LinkedList<>();
        names.add("이름1");
        names.add("이름2");
        names.add("이름3");

        System.out.println(names.poll());
        System.out.println(names.poll());
        System.out.println(names.poll());
    }
}
