package etc.HTTP.Agust;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class HttpRequester {

    public static String getIpAddress(String domain) throws UnknownHostException {
        try {
            domain = domain.replace("http://", "");
            InetAddress[] inetAddresses = InetAddress.getAllByName(domain);

            for (InetAddress ip : inetAddresses) {
                System.out.println("Host Name: " + ip.getHostName()
                        + ", IP Address: " + ip.getHostAddress());
            }
            return inetAddresses[0].getHostAddress();
        } catch (UnknownHostException e) {
            throw new UnknownHostException("UnknownHostException occurred.");
        }
    }

    public static void request(String hostIP) {
        try (Socket socket = new Socket(hostIP, 80);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            sendMessage(out, new File("requestHeader.txt"));
            readResponse(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendMessage(BufferedWriter out, File request) throws IOException {
        System.out.println("\n[Request]");

        for (String line : getHeader(request)) {
            System.out.println(line);
            out.write(line + "\r\n");
        }
        out.write("\r\n");
        out.flush();
    }

    private static void readResponse(BufferedReader in) throws IOException {
        System.out.println("\n[Response]");

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
    }

    private static List<String> getHeader(File file) throws IOException {
        List<String> contents = new ArrayList<>();

        BufferedReader header = new BufferedReader(new FileReader(file));
        String line;
        while ((line = header.readLine()) != null) {
            contents.add(line);
        }
        header.close();

        return contents;
    }

    public static void main(String[] args) throws UnknownHostException {
        String hostIP = getIpAddress("www.disney.co.kr");
        request(hostIP);
    }
}