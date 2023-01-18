package concurrent;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class CompletableFuturesExample03 {

    public static void main(String[] args) {
        log("starting...");

        CompletableFuture
                .supplyAsync(() -> { // supply or generate a value and take nothing
                    heavyProcessing();
                    int num = new Random().nextInt(20);
                    log("num: " + num);
                    return num;
                })
                .thenApply(n -> { // take a value, apply transformation, return new value
                    heavyProcessing();
                    log("Applying doubler");
                    return n * 2;
                })
                .thenAccept(n -> { // accept or take a value and eat it, return nothing
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
