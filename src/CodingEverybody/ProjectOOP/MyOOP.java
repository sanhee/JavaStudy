package CodingEverybody.ProjectOOP;


public class MyOOP {
    public static String delimiter = "";
    public static void main(String[] args) {

        delimiter = "----";
        //.. 1억줄이 있다.
        PrintA(); //m 우클릭 - Refactor - Extract Method
        //.. 1억줄
        PrintA();
        // ..
        PrintB();
        PrintB();

        delimiter = "****";
        PrintA();
        PrintA();
        PrintB();
        PrintB();

        //m 구분자를 다르게 하고싶다면?
        //m 방법1. 각각의 메소드에 파라미터 즉, 매게변수를 주는 것
        //m 방법2. 전역변수를 통해서 사용
        //m 하지만 위 방법들은 코드가 많아진다면 정말 비효율적임
        //m 따라서 클래스를 사용!

    }

    private static void PrintA() {
        System.out.println(delimiter); // 정말 중요한 코드라고 가정
        System.out.println("A"); // 서로 연관된 로직
        System.out.println("A"); // 서로 연관된 로직
    }
    private static void PrintB() {
        System.out.println(delimiter); // 정말 중요한 코드라고 가정
        System.out.println("A"); // 서로 연관된 로직
        System.out.println("A"); // 서로 연관된 로직
    }
}