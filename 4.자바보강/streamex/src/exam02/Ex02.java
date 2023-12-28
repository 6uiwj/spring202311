package exam02;

import java.util.Arrays;
import java.util.Comparator;

public class Ex02 {
    public static void main(String[] args) {
        int[] nums = { 11, 5, 3, 22, 15, 88, 75};
        //내림차순으로 정렬하고 싶어요

        //Intstream
        //boxed()로 일반스트림으로 변환(Stream<Integer>)
        //sorted(Comparator.reverseOrder()) : 내림차순 정렬
        //.mapToInt( x -> x).toArray(); 다시 변환
        int[] nums2 = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder())
                .mapToInt(x -> x).toArray();
        System.out.println(Arrays.toString(nums2));

    }
}
