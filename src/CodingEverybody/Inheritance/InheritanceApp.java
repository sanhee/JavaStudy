package CodingEverybody.Inheritance;

class Cal{
    int v1, v2;
    Cal(int v1, int v2){
        System.out.println("Cal init!!");
        this.v1 = v1;
        this.v2 = v2;
    }
    public int sum(){
        return this.v1+v2;
    }
}

class Cal3 extends Cal{
    //m 부모클래스에 생성자 함수를 추가 했더니 에러가 생김!
    //m 부모를 계승했다면, Cal이 인스턴스로 만들어졌을 때, 반드시 해야하는 일이 생성자에 있음.
    //m 따라서, 자식 클래스는 생성자 함수를 만들고, 부모 클래스를 호출 해야함.
    Cal3(int v1, int v2) {
        super(v1, v2);
        System.out.println("Cal3 init!!");
    }
    public int minus(){
        return this.v1-v2;
    }
}

public class InheritanceApp {
    public static void main(String[] args) {

        Cal c = new Cal(2,1);
        Cal3 c3 = new Cal3(3,1);
        System.out.println(c3.sum());
        System.out.println(c3.minus());

    }
}
