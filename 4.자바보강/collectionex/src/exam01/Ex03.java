package exam01;

import java.sql.Statement;
import java.util.Stack;

public class Ex03 {
    public static void main(String[] args) {
        Stack<String> names = new Stack<>();
        names.push("이름1");
        names.push("이름2");
        names.push("이름3");

        System.out.println(names.pop());
        System.out.println(names.pop());
        System.out.println(names.pop());

    }
}
