package exam02;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        //기본형이 안돼서 Wrapper클래스 형태로 넣어야 한다.
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //항등함수
        //통계@!!
        IntSummaryStatistics stat = nums.stream().mapToInt(x -> x).summaryStatistics();

        long sum = stat.getSum();
        double avg = stat.getAverage();
        long count = stat.getCount();
        int max = stat.getMax();
        int min = stat.getMin();
        //age: 소수점 이하 2자리 까지
        System.out.printf("sum=%d, avg=%.2f, count=%d, max=%d, min=%d%n", sum, avg, count, max, min);
    }
}
