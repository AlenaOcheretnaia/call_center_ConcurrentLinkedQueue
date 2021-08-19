import java.util.concurrent.ConcurrentLinkedQueue;
import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedQueue<Call> callCenterQueue = new ConcurrentLinkedQueue<Call>();

        CallCenter callCenter = new CallCenter(callCenterQueue);
        TelephoneExchange telephoneExchange = new TelephoneExchange(callCenterQueue);

        new Thread(telephoneExchange).start();
        sleep(2000);
        new Thread (callCenter).start();
        sleep(2000);
        new Thread (callCenter).start();
        sleep(2000);
        new Thread (callCenter).start();

    }
}
