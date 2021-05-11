package concurrent;

import java.util.concurrent.*;

public class ScheduledExecutorServiceExample {
    /*
        ScheduledExecutorService runs tasks after some predefined delay and/or periodically.
    */
    public static void main(String[] args) {

        // create
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        // assign task, run the task after 1 sec delay
        Future<String> resultFuture = executorService.schedule(callTask, 1, TimeUnit.SECONDS);

        // run task periodically after a fixDelay
        executorService.scheduleAtFixedRate(runTask, 100, 800, TimeUnit.MILLISECONDS);
    }

    static Callable<String> callTask = () -> {
        System.out.println("["+Thread.currentThread()+"][callable] a heavy task ...");
        TimeUnit.MILLISECONDS.sleep(300);
        return "The result";
    };

    static Runnable runTask = () -> {
        try {
            System.out.println("["+Thread.currentThread()+"][runnable] a heavy task ...");
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

}
