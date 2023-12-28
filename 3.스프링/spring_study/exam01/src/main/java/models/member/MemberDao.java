package models.member;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

public class MemberDao {
    private static Map<String, Member> members = new HashMap<>();
    public void register(Member member) {
        members.put(member.getUserId(), member);
    }

    //값이 존재하니?
    public boolean exists(String userId) {
        return members.containsKey(userId);
    }

    public List<Member> getList() {
        return new ArrayList<>(members.values());
    }
}
