package ModernJava.ch9;

public class ClosureExample {

    public static void main(String[] args) {
        final int number = 100;

        Runnable runnable2 = () -> System.out.println(number);  //m 람다 표현식
        runnable2.run();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(number);  //m 람다 표현식
            }
        };


    }

}
