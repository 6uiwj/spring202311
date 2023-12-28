package exam01;
//모든 정적자원에 바로 접근하게 위해 static 선언
import static exam01.Transportation.*;
public class Ex01 {
    public static void main(String[] args) {
        Transportation bus = BUS;
        System.out.println(BUS == Transportation.BUS);
        System.out.printf("ordinal() : %d, name() : %s%n", bus.ordinal(), bus.name());
    }
}
