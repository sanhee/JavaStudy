package JavaStandard.ch2;

public class CastingEx1 {
    public static void main(String[] args) {
        //형변환이란, 변수 또는 상수의 타입을 다른 타입으로 변환하는 것.
        // 그저 피연산자의 값을 읽어서 지정된 타입으로 형변환 하는 것, 변수 d의 값은 형변환 후 아무런 변화가 없다.
        double d = 85.4;
        int score = (int) d;

        System.out.println("score=" + score);
        System.out.println("d=" + d);
    }
}
