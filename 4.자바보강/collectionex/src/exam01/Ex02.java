package exam01;

import java.util.ArrayList;

public class Ex02 {
    public static void main(String[] args) {
        //데이터를 담고있는 형태의 데이터 군집
        //list -> 가지고있는 데이터가 제일 중요 따라서 toString이 재정의 되어있다.
        ArrayList<String> names = new ArrayList<>();
        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        names.add("이름4");
        names.add("이름5");
        //System.out.println(names);

        //제거
        //for(int i = 0; i < names.size(); i++) {
        //    names.remove(i);
        //}

        for(int i = names.size() - 1; i>=0; i--) {
            String name = names.remove(i);
            System.out.println(name);
        }

        //조회
        for(int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            System.out.println(name);
        }


    }
}
