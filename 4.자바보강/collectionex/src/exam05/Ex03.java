package exam05;

import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        int[][] nums1 = { {10, 20, 30,}, {40, 50, 60}};
        int[][] nums2 = { {10, 20, 30,}, {40, 50, 60}};
        boolean isSame = Arrays.deepEquals(nums1, nums2);

        System.out.println(isSame);
        //다차원배열을 toString으로 비교하면 주솟값만 나온다.
        System.out.println(Arrays.toString(nums1));
        //deepToString을 사용해야 한다.
        System.out.println(Arrays.deepToString(nums1));
    }
}
