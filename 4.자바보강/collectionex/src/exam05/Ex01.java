package exam05;

import java.util.Arrays;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("이름1", "이름2", "이름3");
        //names.add("이름4");
        System.out.println(names);

        //10개를 1로 채워봅시다 (for문없이 간편하게)
        int[] nums = new int[10];
        Arrays.fill(nums, 1);
        System.out.println(Arrays.toString(nums));
    }
}
