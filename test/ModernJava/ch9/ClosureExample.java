package ModernJava.ch9;

public class ClosureExample {

    public static void main(String[] args) {
        final int number = 100;

        System.out.println("Anonymous Class");
        final Runnable runnable = new Runnable() { //m 익명함수
            @Override
            public void run() {
                System.out.println(number);
            }
        };
        runnable.run();

        System.out.println("Lambda");
        Runnable runnable2 = ()-> System.out.println(number);  //m 람다 표현식
        runnable2.run();

    }

}
