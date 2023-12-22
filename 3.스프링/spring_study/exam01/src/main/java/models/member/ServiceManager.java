package models.member;

public class ServiceManager {
    //싱클톤은 최초에 한번 생성, 한번 생성되어있으면 그때부턴 만들어진 객체를 공유한다...
    private static ServiceManager instance = null;
    private ServiceManager() {}

    //객체를 외부에서 만들지 못하기 때문에 static을 붙여서 정적 메서드로 만든다.
    public static ServiceManager getInstance() {
        if(instance == null) {
           instance = new ServiceManager();
        }
        return instance;
    }
    public MemberDao memberDao() {
        return new CachedMemberDao();
    }

    public JoinValidator joinValidator() {
        //완성된 객체형태로 가져오게 됨
        return new JoinValidator(memberDao());
    }
    public JoinService joinService() {
        //완성된 객체형태로 가져오게 됨
        return new JoinService(memberDao(), joinValidator());
    }

    public ListService listService(){
        ListService listService = new ListService();
        listService.setMemberDao(memberDao());

        return listService;
    }
}
