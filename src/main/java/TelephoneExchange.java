import java.util.concurrent.ConcurrentLinkedQueue;

public class TelephoneExchange implements Runnable{

    protected ConcurrentLinkedQueue<Call> queue = null;

    public TelephoneExchange(ConcurrentLinkedQueue<Call> queue) {
        this.queue = queue;
    }

    public void run() {
        int count = 0;
        while (count < 50) {
            try {
                Call call = new Call(count);
             queue.offer(call);
                    System.out.println(count + " calling...");
                    count++;

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}