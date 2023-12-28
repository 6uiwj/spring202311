package exam02;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@MyAnno2(nums=10) //value = "값"
public class Ex01 {
    public static void main(String[] args) {
        Class cls = Ex01.class;
        //Annotation anno = cls.getAnnotation(MyAnno2.class); 아래와 같은 코드
        MyAnno2 anno = (MyAnno2)cls.getAnnotation(MyAnno2.class);
        String value = anno.value();
        System.out.printf("value=%s%n", value);

        int[] nums = anno.nums();
        System.out.println(Arrays.toString(nums));
    }
}
