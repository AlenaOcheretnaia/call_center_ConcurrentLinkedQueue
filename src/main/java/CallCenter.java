import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter implements Runnable{

    protected ConcurrentLinkedQueue<Call> queue = null;

    public CallCenter(ConcurrentLinkedQueue<Call> queue) {
        this.queue = queue;
    }

    public void run() {
        while (!queue.isEmpty()) {
            try {
                System.out.println(Thread.currentThread().getName() + " handle " + queue.poll());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}