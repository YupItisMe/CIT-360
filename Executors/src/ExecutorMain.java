import java.util.concurrent.*;

public class ExecutorMain {

    public static void main(String[] args) {

//       Will run 10 at the same time
        ExecutorService newExec = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            Runnable worker = new MultiThread(" " + i);
            newExec.execute(worker);
        }
        newExec.shutdown();

        while (!newExec.isTerminated()) {
        }

        System.out.println("All threads are finished");
    }

    
}
