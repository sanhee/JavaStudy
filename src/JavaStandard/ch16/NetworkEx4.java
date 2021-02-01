package JavaStandard.ch16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkEx4 {
    public static void main(String[] args) {
        URL url = null;
        BufferedReader input = null;
        String address = "http://example.com/";
        //String address = "http://naver.com/";
        String line = "";

        try {
            url = new URL(address);

            //m openStream(): URL과 연결된 URLConnection의 InputStream을 얻는다.
            input = new BufferedReader(new InputStreamReader(url.openStream()));

            while((line=input.readLine()) !=null){
                System.out.println(line);
            }
            input.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
