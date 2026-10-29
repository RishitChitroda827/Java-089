import java.util.concurrent.*;

public class ThreadPoolRunner {
    public static void main(String[] args)throws InterruptedException, ExecutionException{

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i =0; i<10; i++){

            int taskNumber = i;
            String threadName = Thread.currentThread().getName();


                executorService.execute(() -> {
                System.out.println(threadName + " is executing task" + taskNumber);
            });

            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Task " + taskNumber + " submitted by " + threadName);
        }

        executorService.shutdown();

    }
}
