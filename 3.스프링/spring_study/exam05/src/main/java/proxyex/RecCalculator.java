package proxyex;

public class RecCalculator implements Calculator{
    @Override
    public long factorial(long num) {
        long stime = System.nanoTime();

        if(num <1) {
            return 1L;
        }
        return num * factorial(num -1);
    }
}
