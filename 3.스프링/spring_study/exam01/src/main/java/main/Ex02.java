package main;

import models.Greeter;

import java.lang.reflect.Method;

public class Ex02 {
    public static void main(String[] args) {
        Class cls = Greeter.class; //클래스 정보가 담겨 있는 객체

        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
