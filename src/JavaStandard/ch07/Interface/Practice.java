package JavaStandard.ch07.Interface;

class Human{
    int age = 15;
    void eat(){
        System.out.println("Human");
    }
}

interface HumanAble {
    public static final int age = 20;
    public abstract void eat();
}

class sanhee extends Human implements HumanAble{
    @Override
    public void eat() {
        super.eat();
    }

    //m Reference to 'age' is ambiguous, both 'Human.age' and 'HumanAble.age' match
    //int age_ = age;

    int age_0 = HumanAble.age;
    int age_1 = super.age;
}

public class Practice {

    public static void main(String[] args) {
        sanhee sanhee = new sanhee();

        System.out.println("HumanAble.age:" +sanhee.age_0);
        System.out.println("super.age:" +sanhee.age_1);
    }
}