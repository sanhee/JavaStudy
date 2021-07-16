package etc.HTTP.K;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

public class HTTPRequest {
    private URL url;
    private String requestLine;
    private Map<String, String> headers;

    public HTTPRequest(URL url) {
        this.url = url;
        this.headers = new LinkedHashMap<>();

        requestLine = "GET " + url.getFile() + " " + url.getProtocol().toUpperCase() + "/1.1\r\n";

        String host = url.getHost() + ((url.getPort() == -1) ? "" : ":" + url.getPort());
        headers.put("Host", host);
    }

    public void addHeader(String field, String value) {
        headers.put(field, value);
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(requestLine);
        headers.forEach((k, v) -> {
            stringBuilder.append(k);
            stringBuilder.append(": ");
            stringBuilder.append(v);
            stringBuilder.append("\r\n");
        });
        stringBuilder.append("\r\n");
        return stringBuilder.toString();
    }
}
