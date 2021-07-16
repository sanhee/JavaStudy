package etc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureEx1 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor(); //m 비동기 task가 수행될 thread를 생성한다.

        CompletableFuture
                .runAsync(() -> { //m runAsync(): 다른 쓰레드에서 비동기식으로 동작할 로직를 선언
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    ;
                    System.out.println("Hello!");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    ;
                }, executor)

                .thenRun(() -> System.out.println(" World")); //m .thenRun(): 첫번째 타스크가 완료된 이후에 연속적으로 동작할 로직을 선언

        System.out.println("async request is ready.");

    }
}
