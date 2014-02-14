/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thread.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MainTest {

    private static void arrayBlockingQueueImpl() throws Exception {
        BlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(4);

        Producer[] producers = null;
        Consumer consumer = null;


        producers = new Producer[]{
            new Producer("P-ONE", q),
            new Producer("P-TWO", q),
            new Producer("P-THREE", q)
        };
        
        consumer = new Consumer("CON", q);

        for (Producer p : producers) {
            p.start();
        }
        consumer.start();
    }
    
  

    public static void main(String[] args) {
        try {
            arrayBlockingQueueImpl();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
