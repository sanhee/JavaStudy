package etc.Hiding;

public class Cat extends Animal {

    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }

    @Override
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }

    public static void main(String[] args) {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;

        testClassMethod();
        Cat.testClassMethod();
        Animal.testClassMethod();
        myAnimal.testClassMethod();
        myAnimal.testInstanceMethod();
    }
}
