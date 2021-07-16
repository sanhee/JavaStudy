package JavaStandard.ch07;

final class Singleton {
    //m getInstance()에서 사용될 수 있도록 인스턴스가 미리 생성 되어야 하므로 static
    private static Singleton s = new Singleton();

    private Singleton() { //m 생성자의 접근 제한자
        //m 생성자의 접근제한자는 보통 class와 동일 한대 다르게 지정 가능 하다.
        System.out.println("인스턴스 생성완료.");
    }

    //m 인스턴스를 생성하지 않고도 호출 할 수 있어야 하므로 static
    public static Singleton getInstance() {
        return s;
    }

}

public class SingletonTest {

    public static void main(String[] args) {
        //Singleton s = new Singleton(); //m 에러
        Singleton s = Singleton.getInstance();
    }
}
