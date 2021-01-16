package CodingEverybody.Inheritance;

class Cal{
    public int sum(int v1, int v2){
        return v1+v2;
    }
}

class Cal2{
    public int sum(int v1, int v2){
        return v1+v2;
    }
    public int minus(int v1, int v2){
        return v1-v2;
    }
}

// 내가 만든 클래스가 아니거나(자바내장 함수 등..) 하면 클래스 수정을 못함
// 방법1) 수정이 필요하다면, 클래스 복사후 minus 메소드 구현
// 문제점=오리지널 cal의 sum 메소드에 버그가 있어서 수정을 했다면, 같은 내용을 갖고있는 Cal2의 sum 또한 수정을 해야하는데 난감해짐.
// 중복으로 인한 고통이 생김
// 해결법 -> 상속(Inheritance)

public class InheritanceApp {
    public static void main(String[] args) {
        Cal c = new Cal();
        System.out.println(c.sum(2,1));
    }
}
