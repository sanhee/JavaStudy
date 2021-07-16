package etc;

import java.util.concurrent.CompletableFuture;

public class thenApplyEx {

    public static void main(String[] args) {
        CompletableFuture cf = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
            }
            ;

            return "result A on thread " + Thread.currentThread().getId();

        })

                .thenApply(str -> str + "+ tailed")

                .thenAccept(finalResult -> System.out.println(finalResult));


        System.out.println("Task execution requested on on thread " + Thread.currentThread().getId());

    }
}
