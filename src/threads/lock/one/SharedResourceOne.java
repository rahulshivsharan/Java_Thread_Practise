/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads.lock.one;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class SharedResourceOne extends Resource{
    
    private final Lock lock = new ReentrantLock();
    
    @Override
    public void resource() throws Exception{
        Thread t = Thread.currentThread();
        System.out.println(t.getName()+" in method 'resource' ");
        
        for(int x=1;x <= 7; x++){
            System.out.println(t.getName()+", VALUE "+x);
            Thread.sleep(500);
            if(x == 3){
                lock.lock();
            }
        }
        
        lock.unlock();
    }

}
