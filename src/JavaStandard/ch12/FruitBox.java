package JavaStandard.ch12;

import java.util.ArrayList;

interface eatable{
    abstract void eat();
}

class Fruit implements eatable{
    public String toString(){
        return "Fruit";
    }
    @Override
    public void eat() {

    }
}
class Apple extends Fruit {public String toString(){ return "Apple";}}
class Grape extends Fruit{public String toString(){ return "Grape";}}
class Toy {public String toString(){ return "Toy";}}

class Box<T extends Fruit & eatable>{ // 제한된 제네릭 클래스
    ArrayList<T> list = new ArrayList<>();
    void add(T item) {
        list.add(item);
    }
    T get(int i){
        return list.get(i);
    }
    int size(){
        return list.size();
    }
    public String toString(){
        return list.toString();
    }
}

public class FruitBox {
    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Grape> grapeBox = new Box<>();
        //Box<Toy> toyBox = new Box<>(); // 오류

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple()); //m 다형성
        //fruitBox.add(new Toy()); error

        appleBox.add(new Apple());
        appleBox.add(new Apple());
        toyBox.add(new Toy());

        System.out.println(fruitBox);
        System.out.println(appleBox);
        System.out.println(toyBox);
    }
}
