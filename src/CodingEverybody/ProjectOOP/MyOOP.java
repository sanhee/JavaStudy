package CodingEverybody.ProjectOOP;

public class MyOOP {
    public static void main(String[] args) {
        Print p1 = new Print("----"); // Print 라는 클래스를 복제함
        p1.A();
        p1.A();
        p1.B();
        p1.B();

        Print p2 = new Print("****"); // Print 라는 클래스를 복제함
        p2.A();
        p2.A();
        p2.B();
        p2.B();

        p1.A();
        p2.A();
        p1.A();
        p2.A();

    }
}