package ioPractice;

import java.io.*;

public class CopyLine {

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader("src/noeul.txt"));
             PrintWriter out = new PrintWriter(new FileWriter("src/copy_noeul.txt"))) {

            String line;

            while ((line = in.readLine()) != null) {
                out.print(line);
            }
        }
    }
}
