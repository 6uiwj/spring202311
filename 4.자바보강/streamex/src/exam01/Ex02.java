package exam01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex02 {
    public static void main(String[] args) {
        String[] words1 = { "aaa", "aaa", "bb", "ccc", "ccc", "abcd" };
        //distince : 중복 제거 -> EqualsAndHashCode가 정의되어 있어 얘를 가지고동등성을 비교하여 제거한다.
        //이 내부밖에 쓰이지 않으므로 람다식으로 짧게 표현
        //중복이 없는 개체 중 3글자 이상인 것을 출력하는 식
        Arrays.stream(words1)
                .distinct()  //중간연산
                .filter(s -> s.length() >= 3) //중간 연산
                .forEach(System.out::println); //최종 연산
        //forEach가 최종연산. 이뇨속을 호출해야지만 모든 연산이 끝난다. foreach가 없으면 결과출력X

        /*
        List<String> words2 = Arrays.asList("aaa", "aaa", "bb", "ccc", "ccc", "abcd");
        Stream<String> stm = words2.stream();
        stm.distinct()
                .filter(s -> s.length() >= 3)
                .forEach(System.out::println);
        stm.distinct()
                .filter(s -> s.length() >= 3)
                .forEach(System.out::println);
        //words2다시 출력해보면 원본 데이터가 그대로 있다. (스트림은 내부에서만 쓰이기 때문에)
        //System.out.println(words2);

         */
    }
}
