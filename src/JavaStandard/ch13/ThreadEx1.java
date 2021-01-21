package JavaStandard.ch13;

public class ThreadEx1 {
    public static void main(String[] args) {

        ThreadEx_1 t1 = new ThreadEx_1(); // 스레드 생성 방법 1


        Runnable r = new ThreadEx_2();  // 스레드 생성 방법 2, Runable 인터페이스의 인스턴스를 Thread의 매게변수로 사용
        Thread t2 = new Thread(r);

        Runnable r2 = new Runnable() {  // 스레드 생성 방법3, 2와 같지만 익명 클래스 사용
            @Override
            public void run() {
                System.out.println("t3");
            }
        };
        Thread t3 = new Thread(r2);


        t1.start();
        t2.start();
        t3.start();


    }
}

class ThreadEx_1 extends Thread{
    @Override
    public void run() {
        int[] a = {1,2,3,4,5};
        for(int i: a){
            System.out.println(getName()); // 조상인 스레드의 getName()을 호출
        }
    }
}

class ThreadEx_2 implements Runnable{
    @Override
    public void run() {

        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()); //m 현재 실행중인 Thread 를 반환한다.
        }

    }
}