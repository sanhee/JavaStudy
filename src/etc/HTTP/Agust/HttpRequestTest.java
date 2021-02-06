package etc.HTTP.Agust;

import java.io.*;

public class HttpRequestTest {
    private static void testGetIpAddress() throws IOException {
        File domains = new File("domains.txt");
        BufferedReader input = new BufferedReader(new FileReader(domains));

        String line;
        while ((line = input.readLine()) != null) {
            System.out.printf("\n[%s]\n", line);
            HttpRequester.getIpAddress(line);
        }
        input.close();
    }

    private static void testHttpRequest() throws IOException {
        String hostIP = HttpRequester.getIpAddress("www.disney.co.kr");
        HttpRequester.request(hostIP);
//        Thread.sleep(3000L);

    }

    public static void main(String[] args) throws IOException {
//        testGetIpAddress();
        testHttpRequest();
    }
}