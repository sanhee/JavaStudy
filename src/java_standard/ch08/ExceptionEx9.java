package JavaStandard.ch08;

public class ExceptionEx9 {

    public static void main(String[] args) {

        System.out.println("예외를 강제로 만들어보는 테스트입니다.");
        try {
            throw new Exception("고의로 발생시켰음");
        } catch (Exception e) {
            System.out.println("정상적으로 예외사항을 catch 하였습니다.");
        }
        System.out.println("예외사항이 발생하였지만, try-catch로 예외처리를 해주었기 때문에");
        System.out.println("프로그램이 정상종료 되었습니다.");
    }
}
