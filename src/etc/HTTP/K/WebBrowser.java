package etc.HTTP.K;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class WebBrowser {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("URL을 입력하세요.");
        String input = scanner.nextLine();
        URL url = null;

        try {
            url = new URL(input);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        InetAddress inetAddress = null;
        String ip = null;
        try {
            System.out.println("(DNS Lookup...)");
            inetAddress = InetAddress.getByName(url.getHost());
            StringBuilder stringBuilder = new StringBuilder();
            byte[] ipAdress = inetAddress.getAddress(); // string으로 받을 수 있을텐데?
            stringBuilder.append(ipAdress[0] & 0xFF);
            for (int i = 1; i < ipAdress.length; i++) {
                stringBuilder.append('.');
                stringBuilder.append(ipAdress[i] & 0xFF);
            }

            ip = stringBuilder.toString();
            System.out.println(ip);
        } catch (UnknownHostException e) {
            System.out.println("Unknown Host");
            System.exit(-1);
        }

        System.out.printf("%n== HTTP Request ==%n");
        HTTPRequest request = new HTTPRequest(url);
        request.addHeader("User-Agent", "Mozilla/5.0");
        request.addHeader("Accept-Language", "ko");
        System.out.print(request);

        SocketAddress address = new InetSocketAddress(url.getHost(), 80);

        HTTPResponse response = new HTTPResponse();

        try (Socket socket = new Socket()) {
            socket.connect(address, 3000);
            OutputStream output = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            output.write(request.toString().getBytes());

            // header parse
            StringBuilder sb = new StringBuilder();
            int prev = 0;
            boolean statusLine = true;
            while (true) {
                int data = in.read();
                if (data == -1) {
                    break;
                }
                if (data == '\r') {
                    prev = data;
                    continue;
                } else if (data == '\n') {
                    if (prev == '\r') {
                        if ("".equals(sb.toString())) {
                            break;
                        } else if (statusLine) {
                            response.setStatus(sb.toString());
                            statusLine = false;
                        } else {
                            response.addHeader(sb.toString());
                        }
                        sb.setLength(0);
                        prev = 0;
                    }
                } else {
                    sb.append((char) data);
                }

            }

            System.out.printf("== HTTP Response ==%n");
            System.out.println(response.getHeader());

            System.out.printf("== HTTP Response Body ==%n");

            prev = 0;
            sb.setLength(0);

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024 * 8];
            if (response.isChunked()) {
                while (true) {
                    int chunkSize = 0;
                    while (true) {
                        int data = in.read();
                        if (data == -1) {
                            break;
                        }
                        if (data == '\r') {
                            prev = data;
                        } else if (data == '\n') {
                            if (prev == '\r') {
                                // System.out.println("ChunkSize");
                                if (!"".equals(sb.toString())) {
                                    chunkSize = Integer.parseInt(sb.toString(), 16);
                                    // System.out.println(chunkSize);
                                }
                                sb.setLength(0);
                                prev = 0;
                                break;
                            }
                        } else {
                            sb.append((char) data);
                        }
                    }

                    if (chunkSize == 0) {
                        break;
                    }

                    while (chunkSize > 0) {
                        int len = 0;
                        int readSize = Math.min(buf.length, chunkSize);
                        len = in.read(buf, 0, readSize);
                        out.write(buf, 0, len);
                        chunkSize -= len;
                    }
                }
            } else if (response.getContentLength() > 0) {
                int size = response.getContentLength();
                while (size > 0) {
                    int len = 0;
                    int readSize = Math.min(buf.length, size);
                    len = in.read(buf, 0, readSize);
                    out.write(buf, 0, len);
                    size -= len;
                }
            }

            response.setBody(out.toByteArray());

            System.out.println(new String(response.getBody(), StandardCharsets.UTF_8));

            out.close();
            in.close();
            output.close();
        }
    }
}
