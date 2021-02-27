package etc.Thread;

public class Task2 extends Thread{

    private int customId;
    private int size;
    public Task2(int customID, int size){
        this.customId = customID;
        this.size = size;
    }
    @Override
    public void run(){
        // Thread 한테 매게변수를 어떻게 전달해줄까?
        // 1. public static (위험하다 SLACK에서 확인)

        for(int i =0; i< size;i++){
            if(customId % 2 == 0){ // 커스텀 번호 기준 출력이 다름.
                System.out.println("*****");
            }else{
                System.out.println("......");
            }

        }
    }


    public static void main(String[] args) {

        final int n = 200000; // 불필요한 static 변수 정적변수가 제거됨.
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
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("경과 시간: "+(end-start));
    }
}
