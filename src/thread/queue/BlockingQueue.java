/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thread.queue;

import java.util.LinkedList;
import java.util.Queue;


public class BlockingQueue {
    private final Queue<Integer> queue = new LinkedList<Integer>();
    private static final int MAX = 4;
    
    public synchronized void put(Integer e) throws Exception{
        System.out.println(queue);
        Thread t = Thread.currentThread();
        if(this.queue.size() == MAX){
            System.out.println(t.getName()+" : Producer Waiting ..");
            this.wait();
        }else{
            System.out.println(t.getName()+" : Adding.. "+e);
            queue.add(e);
            this.notifyAll();
        }
    }
    
    public synchronized void get() throws Exception{
        System.out.println(queue);
        Thread t = Thread.currentThread();
        if(this.queue.size() == 0){
            System.out.println(t.getName()+" : Consumer Waiting ..");
            this.wait();
        }else{
            System.out.println(t.getName()+" : Consuming.. ");
            queue.remove();
            this.notifyAll();
        }
    }
}
