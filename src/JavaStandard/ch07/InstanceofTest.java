package JavaStandard.ch07;

public class InstanceofTest {
    public static void main(String[] args) {
        FireEngine fe = new FireEngine();
        Car fe2 = new Car();

        //m instanceof 는 참조변수가 참조하고 있는 인스턴스의 실제 타입(클래스)를 알아보는 것.
        if(fe2 instanceof FireEngine){
            System.out.println("This is a FireEngine instance.");
        }
        if(fe2 instanceof Car){
            System.out.println("This is a Car instance.");
        }
        if(fe2 instanceof Object){
            System.out.println("This is an Object instance");
        }
    }// main close
}

class Car{}
class FireEngine extends Car{}