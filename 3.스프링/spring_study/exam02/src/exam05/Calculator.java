package exam05;

public interface Calculator {
    int num = 10; //public static final
    public abstract int add(int num1, int num2);//public abstract

    default int minus(int num1, int num2) {
        return num1- num2;
    }

}
