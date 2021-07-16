package JavaStandard.ch16;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class NetworkEx1 {
    public static void main(String[] args) {
        //m InetAddress : 자바에서 IP 주소를 다루기 위한 클래스
        InetAddress ip = null;
        InetAddress[] ipArr = null;

        try {
            //m getByname() : 도메인명(host)에 지정된 모든 호스트의 IP주소를 배열에 담아 반환
            ip = InetAddress.getByName("www.naver.com");
            System.out.println("getHostName(): " + ip.getHostName());
            System.out.println("getHostAddress(): " + ip.getHostAddress());
            System.out.println("toString(): " + ip.toString());

            //m getAddress() IP주소를 byte 배열로 반환한다.
            //m 궁금한점. getAddress() :[125, -47, -34, -115] 와 같이 음수가 출력이 되는 이유는 무엇일까?
            byte[] ipAddr = ip.getAddress();
            System.out.println("getAddress() :" + Arrays.toString(ipAddr));

            String result = "";
            for (int i = 0; i < ipAddr.length; i++) {
                result += (ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i];
                result += ".";
            }
            System.out.println("getAddress()+256 :" + result);
            System.out.println();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        //-----------------------

        try {
            //m getLocalHost(): 지역호스트의 IP주소를 반환한다.
            ip = InetAddress.getLocalHost();
            System.out.println("getHostName(): " + ip.getHostName());
            System.out.println("getHostAddress(): " + ip.getHostAddress());
            System.out.println();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // -------------------------

        try {
            //m getAllByName() : 도메인명(host)에 지정된 모든 호스트의 IP주소를 배열에 담아 반환한다.
            ipArr = InetAddress.getAllByName("www.naver.com");

            for (int i = 0; i < ipArr.length; i++) {
                System.out.println("ipArr[" + i + "] : " + ipArr[i]);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }//m main end
}
