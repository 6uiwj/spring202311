package exam03;

import exam02.Fruit;

public class juicier {

    public static void make(FruitBox<? super Apple> fruitBox) { //Apple, Fruit, Object
        System.out.println(fruitBox.getItems());
    }

    //아래와 같이도 쓴다.
    public static <T extends Fruit> void make2(FruitBox<T> fruitBox) {
        System.out.println(fruitBox.getItems());
    }

}
