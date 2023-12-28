package exam04;

import java.util.*;

public class Ex01 {
    public static void main(String[] args) {
       // HashMap<String, String> members = new HashMap<>();

        //킷값에 대한 정렬
        //키 자료형에 정의된 comparable interface
        //정렬기준 바꾸기(Comparator.reverseOrder())
        //대안 정렬 기준 java.util.comparator 인터페이스
        TreeMap<String, String> members = new TreeMap<>(Comparator.reverseOrder());
        members.put("user02", "김이름");
        members.put("user01", "이이름");
        members.put("user03", "박이름");
        //기존 것이 대체된다.
        //members.put("user02", "(수정)김이름");

       // members.remove("user02");

        //String name = members.get("user02");
        //System.out.println(name);

        Set<Map .Entry<String, String>> entries = members.entrySet();

        for(Map.Entry<String, String> entry : entries) {
            System.out.printf("key=%s, value=%s%n", entry.getKey(), entry.getValue());
        }

        //키를 가져오자
        Set<String> keys = members.keySet();
        Collection<String> values = members.values();

        System.out.println("key : " + keys);
        System.out.println("values : " + values);
    }
}
