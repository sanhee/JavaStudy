package JavaStandard.ch16;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class NetworkEx2 {
    public static void main(String[] args) {
        try {
            //m URL(Uniform Resource Location)은 인턴세에 존재하는 여러 서버들이 제공하는 자원에 접근할 수 있는 주소를 표현하기 위한 것
            URL url = new URL("http://www.codechobo.com:80/sample/"
                    + "hello.html?referer=javachobo#index1"); //M 링크 작동안함.

            System.out.println("URL = 프로토콜://호스트명:포트번호/경로명/파일명?쿼리스트링#참조");
            System.out.println(url.getAuthority());
            System.out.println(url.getContent());
            System.out.println(url.getDefaultPort());
            System.out.println(url.getPort());
            System.out.println(url.getProtocol());
            System.out.println(url.getQuery());
            //M getRef(): 참조(anchor)를 반환함. ex) index1
            System.out.println(url.getRef());
            System.out.println(url.getUserInfo());
            //m 문자열로 반환
            System.out.println(url.toExternalForm());
            //m URI로 변환
            System.out.println(url.toURI());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


    }
}
