package exam01;

import lombok.*;

//@Getter
//@Setter
//@ToString
//@NoArgsConstructor(access = AccessLevel.PRIVATE)   //기본생성자
//@AllArgsConstructor  //모든 멤버변수 초기화 생성자
//@RequiredArgsConstructor  //어..뭐라고...? 못들음....ㅎ
//@EqualsAndHashCode
@Data  //@Getter @Setter @ToString @EqualsAndHashCode가 한번에 추가 됨
public class Book {
    String title;
    //@NonNull  //null이 아닌 값이 항상 존재해야 한다.(생성자 매개변수에 추가됨)
    private String author;
    private String publisher;



}
