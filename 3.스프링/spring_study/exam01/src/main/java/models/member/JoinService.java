package models.member;

public class JoinService {

    private MemberDao memberDao;
    private JoinValidator validator;

    //생성자를 이용하여 의존성을 주입하는 방법
    public JoinService(MemberDao memberDao, JoinValidator validator) {
        this.memberDao = memberDao;
        this.validator = validator;

    }

    public void join(Member member){
        //데이터 검증
        validator.validate(member);

        //데이터 추가
        memberDao.register(member);
    }
}
