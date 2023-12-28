package models.member;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Member {
    private String userId;
    private String userPw;
    private String confirmPw;
    private String userNm;

    private LocalDateTime regDt;
    private String regDtStr;

}
