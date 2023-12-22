package exam06;

public class Ex03 {
    public static void main(String[] args) {
        Transportation bus = Transportation.TAXI;
        System.out.printf("ordinal: %d, name : %s%n", bus.ordinal(), bus.name());
        //객체를 원래의 형태로 바꿈...
        //Transportation subway = Enum.valueOf(Transportation.class, "SUBWAY");
        //문자열 변수를 다시 Enum 상수로
        Transportation subway = Transportation.valueOf("SUBWAY");

        System.out.println(subway);
    }
}
