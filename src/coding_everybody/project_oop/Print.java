package CodingEverybody.ProjectOOP;

class Print {

    //m 자바) 파일이름 -> 파일 이름의 클래스에서 main 메소드를 찾아서 실행하도록 약속 되어있음.
    //m 클래스 안 변수와 메소드를 멤버라고 한다.

    public String delimiter = "";

    //m 생성자 함수는 초기에 필요한 값이나, 초기화를 위해 사용함.
    //m static을 사용하지 않고, 별도의 리턴이 존재하지 않는다.
    //m this 함수는 인스턴스 변수를 가리키는 것으로 명시적으로 표시해주는 것이 좋다.

    public Print(String delimiter) {
        this.delimiter = delimiter;
    }

    public void A() {
        System.out.println(this.delimiter);
        System.out.println("A");
        System.out.println("A");
    }

    public void B() {
        System.out.println(this.delimiter);
        System.out.println("B");
        System.out.println("B");
    }
}
