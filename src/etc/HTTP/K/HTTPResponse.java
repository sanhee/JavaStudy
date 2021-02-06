package etc.HTTP.K;

import java.util.LinkedHashMap;
import java.util.Map;

public class HTTPResponse {
    private String protocol;
    private String statusText;
    private int statusCode;
    private Map<String, String> headers;

    private int contentLength;
    private byte[] body;

    public HTTPResponse() {
        headers = new LinkedHashMap<>();
        contentLength = 0;
    }

    public void setStatus(String statusLine) {
        String[] lines = statusLine.split(" ");
        this.protocol = lines[0];
        this.statusCode = Integer.parseInt(lines[1]);
        this.statusText = lines[2];
    }

    public void addHeader(String field, String value) {
        this.headers.put(field.toLowerCase(), value);
        if ("Content-Length".equalsIgnoreCase(field)) {
            setContentLength(Integer.parseInt(value));
        }
    }

    public void addHeader(String header) {
        String[] heads = header.split(":", 2);
        if (heads.length == 2) {
            addHeader(heads[0].trim(), heads[1].trim());
        } else {
            addHeader(heads[0].trim(), "");
        }
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public String getHeader() {
        StringBuilder sb = new StringBuilder();
        sb.append(protocol).append(' ');
        sb.append(statusCode).append(' ');
        sb.append(statusText).append("\r\n");
        headers.forEach((k, v) -> {
            sb.append(k).append(": ");
            sb.append(v).append("\r\n");
        });
        return sb.toString();
    }

    public boolean isChunked() {
        return "chunked".equalsIgnoreCase(headers.get("Transfer-Encoding".toLowerCase()));
    }

    public int getContentLength() {
        return contentLength;
    }

    public byte[] getBody() {
        return body;
    }
}