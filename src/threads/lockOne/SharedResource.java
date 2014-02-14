/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.lockOne;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class SharedResource {

    private Lock lock = new ReentrantLock();
    private Condition con = lock.newCondition();

    public void counter(int num) throws Exception {
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + " Acess... ");
            lock.lock();
            for (int x = 1; x <= 10; x++) {
                System.out.println(t.getName() + " : " + x);
                if (num == x) {                    
                    con.signal();
                    con.await();
                }
            }
            con.signal();
        } finally {
            lock.unlock();
        }


    }
}
