package etc.Thread;

public class Task extends Thread {

    @Override
    public void run() {
        if(isDaemon()) {
            this.setName("Daemon");
        }
        System.out.printf("I am thread %s (%d)\n", this.getName(), this.getId());
        int count = 0;
        while(isDaemon() || count < 10) {
            try {
                count++;
                Thread.sleep(1000);
                System.out.println(this.getName() + ": "+count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main start!");

        Thread mainThread = Thread.currentThread();
        System.out.printf("Main %s (%d)\n", mainThread.getName(), mainThread.getId());

        Thread task = new Task();
        Thread normal = new Task();
        task.setDaemon(true); // 데몬 스레드, 모든 일반 스레드가 죽으면 자동으로 죽음
        task.start();
        normal.start();
        Thread.sleep(5000);  // 메인 스레드가  5초뒤 종료

        System.out.println("Main thread end");
    }
}
