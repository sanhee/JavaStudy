package etc.Thread;

public class Task2 extends Thread{

    private int customId;
    private long size;
    public Task2(int customID, long size){
        this.customId = customID;
        this.size = size;
    }
    @Override
    public void run(){
        long sum = 0;
        for(int i =0; i< size;i++){
            sum+=i;
        }
        System.out.println("thread ended ("+customId+")");
    }


    public static void main(String[] args) throws InterruptedException {

        final long n = 200_000_0000L; // 스레드 작업량
        final int numThread = 2;
        Thread[] threadArray = new Thread[numThread];


        for(int i = 0 ; i< numThread; i++){
            threadArray[i] = new Task2(i,n);
        }

        // enhanced for은 읽기 전용으로, 배열의 변경은 불가능하다.
       // for(Thread thread : threadArray){
           // thread = new Task2(i,n);
       // }

        long start = System.currentTimeMillis();

        for(Thread thread : threadArray){
            thread.start();
        }
        for(Thread thread : threadArray){
            thread.join();
        }

        long end = System.currentTimeMillis();
        System.out.println("경과 시간: "+(end-start));
    }
}
