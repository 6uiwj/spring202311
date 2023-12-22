package exam01;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //인터페이스지만, 미구현한 메서드를 사용자 정의로 구현함으로써 객체가 될 수 있다.
        //cal: 객체의 주솟값
        /*
        Calculator cal = new Calculator() {
            public int square(int num) {
                return num * num;
            }
        };

        int[] nums2 = calc(nums, cal);
        System.out.println(Arrays.toString(nums2));

         *//*
        int[] nums2 = calc(nums, new Calculator() {
            public int square(int num) {
                return num * num;
            }
        });


     */
        int[] nums2 = calc(nums, x -> x * x);
    }

    //Calculator 인터페이스가 매개변수로 들어가 있음
    public static int[] calc(int[] nums, Calculator cal) {
        int[] nums2 = new int[nums.length];

        //함수를 호출해서 정의한 연산(인터페이스의 수창메서드를 사용자정의)을 한 후 새로운 배열에 넣는다.
        for (int i = 0; i < nums.length; i++ ){
            nums2[i] = cal.square(nums[i]); //단일 기능
        }

        return nums2;
    }
}
