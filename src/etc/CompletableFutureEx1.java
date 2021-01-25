package etc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureEx1 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        CompletableFuture
                .runAsync(()->{
                    try{Thread.sleep(1000);} catch(Exception e){};
                    System.out.println("Hello!");
                    try{Thread.sleep(1000);} catch(Exception e){};
                },executor)

                .thenRun(()->System.out.println("World"));

        System.out.println("async request is ready.");

    }
}
