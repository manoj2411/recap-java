package concurrent;

import java.util.concurrent.*;

/*

    #   Callable vs Runnable
     - both are functional interfaces, i.e. single method to override
     - runnable returns void
     - callable returns the Future of T (type)
       - Future means future value, that we'll eventually resolve.

*/
class FutureAndCallable00 {

    public static void main(String[] args) {
        Callable<String> task1 = new Callable<String>() {
            public String call() { return "Task is done";}
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<String> resultFuture = executor.submit(task1);
        while(!resultFuture.isDone());

        try {
            System.out.println(resultFuture.get());
        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }
}


