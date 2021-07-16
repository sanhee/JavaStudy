package etc.TryWithResource;

import java.io.*;

public class TryWithResourceEx1 {
    public static void main(String[] args) {
        StringBuilder readTextInfo = new StringBuilder();
        char a = 'a';
        char b = 'b';
        char c = 'c';


        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("sample.txt"));
             DataInputStream dis = new DataInputStream(new FileInputStream("sample.txt"))) {
            //저장할때 데이터타입의 바이트 수만큼 그대로 저장하므로 저장한 순서,타입을 맞춰야 제대로 읽음
            dos.writeChar(a);//a를 char값으로 파일에씀
            dos.writeChar(b);
            dos.writeChar(c);
            dos.close(); // 파일과 객체의 연결을 끊으면서 저장함

            while (true) {
                readTextInfo.append(dis.readChar()).append(System.lineSeparator());
            }

        } catch (EOFException e) {
            System.out.println(readTextInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
