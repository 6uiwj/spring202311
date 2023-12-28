package proxyex;

public class ImplCalculator implements Calculator {
    @Override
    public long factorial(long num) {
        long stime = System.nanoTime();

        long total = 1L;

        for(long i = 1L; i <= num; i++){
            total *= i;
        }

        return total;
    }
}
