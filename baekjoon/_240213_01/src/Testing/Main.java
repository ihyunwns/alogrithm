package Testing;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Child> list = new ArrayList<>();
        list.add(new Child(3));
        list.add(new Child(5));

        Object[] o = new Object[2];
        for (int i = 0; i < list.size(); i++) {
            o[i] = list.get(i);
        }

        Test.Testing(list);


        //Test.Testing2(list);
        //컴파일 에러

    }
}
