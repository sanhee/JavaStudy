package annotation.example3;

public class AnnotationExample2 extends AbstractClass{
    // 자동 실행 어노테이션 설정
    @AutoExecute
    public void print(){
        System.out.println("print!!!!");
    }

    // 자동 실행 어노테이션 설정\
    @AutoExecute
    public void run(){
        System.out.println("run!!!!");
    }

    // 일반 메소드
    public void test(){
        System.out.println("test");

    }

    // 실행함수
    public static void main(String[] args) {
        new AnnotationExample2();
    }
}
