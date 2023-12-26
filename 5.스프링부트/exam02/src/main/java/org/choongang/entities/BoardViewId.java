package org.choongang.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//id클래스!!
@EqualsAndHashCode //두값의 조합이 아이디이므로 중복이 있으면 안되기 때문에
//두가지를 매개변수 형태로 추가할 수 있는 생성자, 기본생성자 필요
@AllArgsConstructor @NoArgsConstructor
public class BoardViewId {
    private Long seq;
    private int uid;
}
