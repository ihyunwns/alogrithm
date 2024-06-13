package Testing;

import org.jetbrains.annotations.NotNull;

import java.util.List;

class Test {
    public static <T extends TestInterface<? super T>> void Testing(List<T> list) {
        System.out.println("테스팅");
    }

    public static <T extends TestInterface<T>> void Testing2(List<T> list) {
        System.out.println("테스팅2");
    }

}

class Parent implements TestInterface<Parent>, Comparable<Parent>{
    int p;

    public Parent(int p) {
        this.p = p;
    }

    @Override
    public void test() {
        System.out.println("테스트 부모");
    }

    @Override
    public int compareTo(@NotNull Parent o) {
        if (this.p > o.p) {
            return -1;
        } else if (this.p == o.p) {
            return 0;
        } else {
            return 1;
        }
    }
}

class Child extends Parent{

    public Child(int p) {
        super(p);
    }
}

