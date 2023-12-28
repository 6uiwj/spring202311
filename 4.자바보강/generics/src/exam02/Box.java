package exam02;

public class Box<T extends Fruit> {
    //T: 타입 매개변수 (관례적으로 T 사용)
    private T item; //Object

    //private static T item2; //static은 불가능!
    //pricate T[] item3 = newT[]; 얘도 공간을 얼만큼 할당할지 몰라서 generic 사용을 못해
    public T getItem() {
        return item;
    }
    public void setItem(T item) {
        this.item = item;
    }

    public void printItem(){
        //T는 일단 Object로 결정되어있고, 객체를 만드는 시점에 투입된 타입으로 형변환이 된다.
        //T -> 일단 Fruit으로 한정됨, 객체를 만드는 시점 -> 투입된 타입으로 형변환
        item.print();

    }

    public <T> void testMethod(T t) {
        //지네릭 메서드
    }

}
