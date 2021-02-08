package lambdas;

import java.util.concurrent.Callable;

class RunnableEx {
    void methodAcceptRunnable(Runnable r) {
        r.run();
    }

    void methodAcceptCallable(Callable c) {
        try {
            System.out.println("callable: " + c.call());
        } catch(Exception ex) { }

    }

    public static void main(String[] args) {

        new RunnableEx().methodAcceptRunnable(() -> {
            // do some heavy lifting here
            System.out.println("hey there!");
        });

        new RunnableEx().methodAcceptCallable(() -> "Hello!" );
    }

}
