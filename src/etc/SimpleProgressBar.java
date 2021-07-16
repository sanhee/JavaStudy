package etc;

public class SimpleProgressBar {
    public static void main(String[] args) {
        char[] animateMark = new char[]{'|', '/', '-', '\\'};
        final int MAX_RANGE = 100;

        for (int i = 0; i <= MAX_RANGE; i++) {
            System.out.print(i + "% (" + animateMark[i % 4] + ")" + "\r");  //m \r : 이스케이프 문자:: 개행문자, 커서를 행의 앞으로 옮긴다.
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
