package exam05;

import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args) {
        int[] nums1 = {10, 20, 30, 40};
        int[] nums2 = {10, 20, 30, 40};
        //배열의 비교 - 방법1 : for문 이용
        /*
        boolean isSame = true;
        for(int i= 0; i < nums1.length; i++) {
            if (nums1[i] != nums2[i]) {
                isSame = false;
                break;
            }
        }
        System.out.println(isSame);

         */
        //배열의 비교 - 방법2: equals 메서드
        boolean isSame = Arrays.equals(nums1, nums2);
        System.out.println(isSame);
    }
}
