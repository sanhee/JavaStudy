package JavaStandard.ch09;

import java.util.Objects;

class test {
    private String name;

    public test(String name) {
        //this.name = name;

        this.name = Objects.requireNonNull(name, "어허 NULL 값이다!!");

        System.out.println(this.name);
    }
}

public class ObjectNullCheck {

    public static void main(String[] args) {
        test t = null;
        Object t3 = t;
        System.out.println(Objects.toString(t3, "Null 대신 써줄게!"));
        test t2 = new test(null);
    }
}
