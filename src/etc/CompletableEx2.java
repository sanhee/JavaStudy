package etc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableEx2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println(1);
        CompletableFuture.runAsync(() -> {
            System.out.println("test");
        }).get();
        System.out.println(2);
    }


}
