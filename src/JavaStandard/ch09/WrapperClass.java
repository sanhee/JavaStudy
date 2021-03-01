package JavaStandard.ch09;

import java.math.BigInteger;

public class WrapperClass {
    public static void main(String[] args) {
        BigInteger bg = new BigInteger("1221474834242343867867867896709670670670670242666666666666666666666666666666666666666666666633333333333333332222222222222222222222222223333333333333343647");
        System.out.println(bg);

        Integer i = new Integer("1");
        int i2 = i; // 원래는 불가능 했지만, 자바 컴파일러가 자동으로 오토박싱을 해주어서 가능해진 방식. 즉, 참조변수와 기본형의 계산 가능
        System.out.println(i2);
    }
}
