package ioPractice;

import java.io.*;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream("src/noeul.txt"));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("src/copy_noeul.txt"))){

            int cursor;

            while((cursor = in.read()) != -1){
                out.write(cursor);
            }

        }
    }
}
