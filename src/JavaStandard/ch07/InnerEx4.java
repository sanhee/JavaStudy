package JavaStandard.ch07;

class Outer {

    class InnerClass {
        int instanceVariable = 10;

    }

    static class StaticInner {
        int instanceVariable = 20;
        static int classVariable = 30;
    }

    void method() {
        class LocalInner {
            int instanceVariable = 40;
        }

        LocalInner l = new LocalInner();
        l.instanceVariable = 100;
        System.out.println(l.instanceVariable);
    }


}


public class InnerEx4 {


    public static void main(String[] args) {
        Outer o = new Outer();
        Outer.InnerClass l = o.new InnerClass();

        System.out.println(l.instanceVariable);

        System.out.println(Outer.StaticInner.classVariable);

        Outer.StaticInner si = new Outer.StaticInner();
        System.out.println(si.instanceVariable);

        o.method();

    }

}
