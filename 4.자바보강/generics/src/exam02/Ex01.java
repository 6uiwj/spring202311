package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.setItem(new Apple());

       Apple apple = appleBox.getItem();
        //애플을 담지 않아도 뭐가 담겨있으면 뭐가 담겨있는지 확인

        //Box<Pear> pearBox = new Box<>();
    }
}
