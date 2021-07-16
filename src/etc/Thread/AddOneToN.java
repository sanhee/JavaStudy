package etc.Thread;

class Result {
    public long sum; // 그럼 Long 래퍼 클래스가 될 것 같은데, Synchronized는 Wrapper클래스는 안된다. 실제 클래스만 작동한다. => 구글에는 안나옴ㅋㅋㅋ

    public void add(long i) {
        sum += i;
    }
}

public class AddOneToN extends Thread {
    public AddOneToN(long start, long end, Result result) {
        this.start = start;
        this.end = end;
        this.result = result;
    }

    private long start;
    private long end;
    //m 각각의 스레드가 더하는 건대, 변수를 공유함.
    public final Result result;

    private void sum() {
        long localSum = 0;
        for (long i = start; i <= end; i++) {  // 1부터 n까지  즉, end를 포함해야 연산이됨.
            localSum += i;
        }

        result.add(localSum);
        System.out.println("thread ended (" + getName() + ")");
    }

    @Override
    public void run() {
        sum();
    }

    public static void main(String[] args) throws InterruptedException {

        final long n = 10000000L; // 스레드 작업량
        final int numThread = 8; // 스레드 작업량을 일부 소실하네 ㅋㅋ  작업량이 몇개 날라가네 3, 7, 9, 1
        Thread[] threadArray = new Thread[numThread];
        final long size = n / numThread; // 스레드로 일을 분산해서 처리하기 때문에 1/n 만큼의 업무량

        Result result = new Result();
        result.sum = 0;

        for (int i = 0; i < numThread; i++) {
            long startTime = i * size + 1; //예시. 0, 1*50+1, 2*50+1 ~
            long endTime = (i + 1) * size; // 1*50, 2*50, 3*50~
            threadArray[i] = new AddOneToN(startTime, endTime, result);
        }

        long start = System.currentTimeMillis();

        for (Thread thread : threadArray) {
            thread.start();
        }
        for (Thread thread : threadArray) {
            thread.join();
        }
        long end = System.currentTimeMillis();
        System.out.println("경과 시간: " + (end - start));
        System.out.printf("sum of 1 to %d is %d", n, result.sum); // 1~100, 1000 이렇게 더하면 5와 0의 조합으로 이루어져야 정상

    }
}
