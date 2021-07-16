package JavaStandard.ch08;

import java.io.File;
import java.util.Scanner;

public class ExceptionEx16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String fileName = scanner.nextLine();
            createNewFile(fileName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("잘못되었습니다, 다시 입력하세요.");
        }
        scanner.close();
    }

    private static void createNewFile(String fileName) throws Exception {
        if (fileName == null || fileName.equals("")) throw new Exception("파일이름이 유효하지 않습니다.");
        File f = new File(fileName);
        f.createNewFile();
    }
}
