package CodingEverybody.Inheritance;

class Cal{
    public int sum(int v1, int v2){
        return v1+v2;
    }

    //m Overloading : 동일한 이름의 메소드를 다른 형태(매게변수)로 정의하는 것을 말함
    public int sum(int v1, int v2, int v3){
        return v1+v2+v3;
    }
}

class Cal3 extends Cal{
    public int minus(int v1, int v2){
        return v1-v2;
    }

    //m 부모 클래스의 기능을 재정의
    @Override
    public int sum(int v1, int v2) {
        System.out.println("Cal3");
        return v1+v2;
    }
}

public class InheritanceApp {
    public static void main(String[] args) {
        Cal3 c = new Cal3();
        System.out.println(c.sum(2,1));
        System.out.println(c.sum(2,1,4));
        System.out.println(c.minus(2,1));
    }
}
