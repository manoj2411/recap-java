package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorsExamples02 {

  /*  ExecutorService : for running async tasks on a pool of threads and API for assigning tasks */

  public static void main(String[] args) {
    /*  Instantiating   */

    //  1. Factory Methods of the Executors Class
    ExecutorService executor1 = Executors.newFixedThreadPool(2);
    //  2. Directly Create an ExecutorService
    ExecutorService executor2 =
        new ThreadPoolExecutor(1, 1, 0l, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    // internally using similar code as above
    ExecutorService executor3 = Executors.newSingleThreadExecutor();

    /*  Assigning Tasks to the ExecutorService  */

    // ExecutorService can execute Runnable and Callable tasks
    Runnable runTask = () -> {
        try {
          System.out.println("["+Thread.currentThread()+"][runnable] starting a task ...");
          TimeUnit.MILLISECONDS.sleep(300);
          System.out.println("["+Thread.currentThread()+"][runnable] end of task ...");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
    };

    Callable<String> callTask = () -> {
      System.out.println("["+Thread.currentThread()+"][callable] starting a task ...");
      TimeUnit.MILLISECONDS.sleep(300);
      System.out.println("["+Thread.currentThread()+"][callable] end of task ...");
      return "The result";
    };

    List<Callable<String>> callTasks = new ArrayList<>();
    callTasks.add(callTask);
    callTasks.add(callTask);
    callTasks.add(callTask);

    /*  many ways of assigning tasks to executorService */
    /* execute() : return void */
    executor1.execute(runTask);

    /* submit()  : Future of callable/runnable */
    Future<String> callResult = executor2.submit(callTask);

    /* invokeAny() : return res of 1 of the successful task */
    try {
      String anyResult = executor3.invokeAny(callTasks);
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }

    /* invokeAll() : return res of all tasks */
    try {
      List<Future<String>> resultFutures = executor1.invokeAll(callTasks);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    /*  Shutting Down an ExecutorService
    *     - executor will stay alive and wait for new work
    *     - app could reach its end but not be stopped because a waiting ExecutorService will cause
    *       the JVM to keep running
    * */
    executor1.shutdown(); // stop accepting new tasks and shut down after all running threads finish

    // returns a list of tasks that are waiting to be processed
    List<Runnable> notExecutedTasks = executor2.shutdownNow();

    // Recommended way to shutdown
    executor3.shutdown();
    try {
      if (!executor3.awaitTermination(1, TimeUnit.SECONDS)) {
        executor3.shutdownNow();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}
