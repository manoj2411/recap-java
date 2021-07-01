package concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinEx01 {
    /*
    *   ForkJoin provide tools to use multiple processes to speedup processing in parallel through
    *    divide and conquer approach.
    *
    *  Step : Fork tasks and break them recursively until they are simple enough to be executed.
    *  Step : Join tasks results to build the result or wait for all tasks to compete in case task return void.
    *
    *   To execute tasks it uses pool of threads called the ForkJoinPool which is an implementation
    *    of the ExecutorService that manages worker threads.
    *   Worker threads can execute only one task ata time.
    *
    * */
    public static void main(String[] args) {
        // most convenient way to get access to the instance of the ForkJoinPool is to use its static method commonPool().
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        // The same behavior can be achieved (old way)
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);

        // ForkJoinTask is the base type for tasks executed inside ForkJoinPool. two subclasses of it:
        // 1. RecursiveAction for void tasks
        // 2. RecursiveTask<V> for tasks that return a value
        //  both have an abstract method compute() where logic is placed.

        double[] arr = {1.0, 2.0, 4.0, 5.0, 6.0};
        System.out.println(parArraySum(arr));
    }

    protected static double parArraySum(final double[] input) {
        assert input.length % 2 == 0;

        double sum = 0;

        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        ReciprocalSumTask task = new ReciprocalSumTask(input, input.length / 2, input.length - 1);
        commonPool.execute(task);

        // Compute sum of reciprocals of array elements
        for (int i = 0; i < input.length / 2; i++) {
            sum += 1 / input[i];
        }
        double sum2 = task.join();
        return sum + sum2;
    }

}

class ReciprocalSumTask extends RecursiveTask<Double> {
    double[] arr;
    int low;
    int high;

    ReciprocalSumTask(double[] arr, int low, int high) {
        this.arr = arr;
        this.low = low;
        this.high = high;
    }

    @Override
    protected Double compute() {
        double sum = 0;

        for(int i = low; i <= high; i++) {
            sum += 1 / arr[i];
        }

        return sum;
    }
}
