package exam01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Ex04 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("aa", "bb", "cc");
        //word가 하나씩 넘어오면 이 값을 가지고 사용할 함수 정의 (=여기선 대문자로 만든다.)
        List<String> result = map(words, s-> s.toUpperCase());
        System.out.println(result);
    }
    //매개변수와 반환값이 같으므로 UnaryOperator 사용
    //내부 반복
    //words 단어가 들어옴.. list형태이면 내부에서 반복
    //바꿔준 다음에 추가...? 뭘바꿀지 몰라... 추상메서드니까 아직 몰라...
    //사용자 정의기능.. 우리가 정의해줘야 알아... 휴..뭔소린데..
    public static List<String> map(List<String> words, UnaryOperator<String> oper) {
        List<String> converted = new ArrayList<>();
        for (String word : words ) {
            //인터페이스의 메서드로 값만 넘겨줌 -> 사용할 때 함수 정의
            String word2 = oper.apply(word);
            converted.add(word2);
        }

        return converted;
    }
}
