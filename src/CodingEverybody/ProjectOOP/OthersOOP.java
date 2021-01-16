package CodingEverybody.ProjectOOP;

import java.io.FileWriter;
import java.io.IOException;

public class OthersOOP {
    public static void main(String[] args) throws IOException {

        //m 클래스 : System, Math, FileWriter
        //m 인스턴스 : f1, f2가 가리키는 값

        //m 내부적으로 어떠한 상태를 유지할 필요가 없음.
        //m 필요할때마다 쓰는 일회용
        //m 클래스에 있는 변수나 메소드 그대로 사용
        System.out.println(Math.PI);
        System.out.println(Math.floor(1.8));
        System.out.println(Math.ceil(1.8));

        //m 클래스를 직접 사용하는 것이 아니라, 클래스를 복제해서 제어한다.
        FileWriter f1 = new FileWriter("data.txt");
        f1.write("Hello");
        f1.write(" Java");


        FileWriter f2 = new FileWriter("data2.txt");
        f2.write("Hello");
        f2.write(" Java2");
        f2.close();

        f1.write("!!!");
        f1.close();
 
    }
}
