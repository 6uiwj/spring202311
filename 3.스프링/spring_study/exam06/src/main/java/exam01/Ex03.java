package exam01;

public class Ex03 {
    public static void main(String[] args) {

        try (MyResource my = new MyResource()) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
