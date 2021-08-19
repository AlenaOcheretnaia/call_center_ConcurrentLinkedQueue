//PriorityBlockingQueue  -  не подходит, так как не гарантируется  FIFO, а для call центра этот принцип имеет значение
//DelayQueue  - блокировка потоков, можно использовать, если реализовывать очередь с минимальным временем ожидания,
// но не гарантируется FIFO + interface
//ConcurrentLinkedDeque - работа с двух сторон, медленная - для нашей задачи избыточна
//ArrayBlockingQueue - блокировка потоков, может работать по FIFO, нерасширяемая - не подходит для колл-центра,
// либо должна быть заведомо очень большая
// LinkedBlockingDeque - двунаправленная - избыточна для нашей задачи
//SynchronousQueue - блокировка, пока не заберут, честная блокировка
//LinkedTransferQueue - блокировка, гибкость - по таймауту
//
//  Выбирала между  LinkedBlockingQueue  и СoncurrentLinkedQueue - склонялась изначально к первой,
//  но потом решила остановиться на очереди без блокировки потоков.

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
