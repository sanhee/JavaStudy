package etc;

import java.util.concurrent.CompletableFuture;

public class thenRunAsyncEx {
    public static void main(String[] args) {
        CompletableFuture cf= CompletableFuture.runAsync(() -> {

            try{Thread.sleep(1000);} catch(Exception ex){

                System.out.println("Exception"+ex.getMessage());

            };

            System.out.println("runAsync on thread "+Thread.currentThread().getId());

        })

                .thenRunAsync( //m  Run이라는 동사의 의미는 인자를 받지 않고 결과를 리턴하지 않는 타스크입력값을 받는 다는 의미이다.

                        ()->System.out.println("thenRunAsync on thread "+Thread.currentThread().getId())

                );



        System.out.println("Task execution requested on thread " + Thread.currentThread().getId());

    }
}
