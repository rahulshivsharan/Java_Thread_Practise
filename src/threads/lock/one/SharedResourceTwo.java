/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads.lock.one;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class SharedResourceTwo extends Resource{

    private final Lock lock = new ReentrantLock();
    
    @Override    
    public void resource(int num) throws Exception {
        Thread t = Thread.currentThread();
        lock.lock();
        System.out.println(t.getName()+", VALUE "+num);
        this.notify();
        this.wait();
        lock.unlock();
    }
    
}
