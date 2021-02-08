package concurrent;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class CompletableFuturesEx {

    public static void main(String[] args) {
        log("starting...");

        CompletableFuture
                .supplyAsync(() -> {
                    heavyProcessing();
                    int num = new Random().nextInt(20);
                    log("num: " + num);
                    return num;
                })
                .thenApply(n -> {
                    heavyProcessing();
                    log("Applying doubler");
                    return n * 2;
                })
                .thenAccept(n -> {
                    heavyProcessing();
                    log("Final number: " + n);

                }).join();

    }

    static void heavyProcessing() {
        for(int i = 0; i < 10_000_000; i++) {
            String s = "*" + String.valueOf(i) + "*";
        }
    }
    static void log(String message) {
        System.out.println("[" + LocalDateTime.now() + " " + Thread.currentThread() + "]: " + message);
    }
}
