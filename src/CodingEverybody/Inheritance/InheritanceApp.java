package CodingEverybody.Inheritance;

class Cal{
    public int sum(int v1, int v2){
        return v1+v2;
    }
}

class Cal3 extends Cal{
}

public class InheritanceApp {
    public static void main(String[] args) {
        Cal3 c = new Cal3();
        System.out.println(c.sum(2,1));
    }
}
