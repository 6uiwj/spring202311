package exam04;

public class Ex03 {
    public static void main(String[] args) {
        Book3 b1 = new Book3("책1", "저자1", "출판사1");
        System.out.printf("title=%s, author=%s, publisher=%s%n",
                b1.title(), b1.author(), b1.publisher());
        System.out.println(b1);
    }
}
