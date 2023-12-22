package exam01;

public class Ex03 {
    public static void main(String[] args) {
        System.out.println(Transportation.BUS instanceof Transportation);

        //Transportation trans = new Transportation();
        int totalFare = Transportation.BUS.getTotal(10);
        System.out.println(totalFare);
    }
}
