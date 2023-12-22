package exam03;

public class Human extends Animal {
    @Override
    public void move(){
        System.out.println("두 발로 직립보행...");
    }
    public void readBook(){
        System.out.println("독서를 한다.");
    }
}
