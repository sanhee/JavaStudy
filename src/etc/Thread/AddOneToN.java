package etc.Thread;

public class AddOneToN extends Thread{
    public AddOneToN(long start, long end){
        this.start = start;
        this.end = end;
    }
    private long start;
    private long end;
    //m 각각의 스레드가 더하는 건대, 변수를 공유함.
    public static long result;

    @Override
    public void run(){
        for(long i =start; i<= end;i++){  // 1부터 n까지  즉, end를 포함해야 연산이됨.
            result+=i;
            System.out.println(result);
        }
        System.out.println("thread ended ("+getName()+")");
    }


    public static void main(String[] args) throws InterruptedException {

        final long n = 1000_000L; // 스레드 작업량
        final int numThread = 3;
        Thread[] threadArray = new Thread[numThread];
        final long size = n/numThread; // 스레드로 일을 분산해서 처리하기 때문에 1/n 만큼의 업무량

        for(int i = 0 ; i< numThread; i++){
            long startTime = i*size+1; //예시. 0, 1*50+1, 2*50+1 ~
            long endTime = (i+1)*size; // 1*50, 2*50, 3*50~
            threadArray[i] = new AddOneToN(startTime,endTime);
        }

        long start = System.currentTimeMillis();

        for(Thread thread : threadArray){
            thread.start();
        }
        for(Thread thread : threadArray){
            thread.join();
        }
        long end = System.currentTimeMillis();
        System.out.println("경과 시간: "+(end-start));
        System.out.printf("sum of 1 to %d is %d",n, AddOneToN.result); // 1~100, 1000 이렇게 더하면 5와 0의 조합으로 이루어져야 정상

    }
}

