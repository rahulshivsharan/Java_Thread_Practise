/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thread.blockingQueue;

import java.util.concurrent.BlockingQueue;







/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Consumer extends Thread{
    
    private volatile BlockingQueue<Integer> queue;
    
    public Consumer(String name,BlockingQueue<Integer> queue){
        this.setName(name);
        this.queue = queue;
    }
    
    private int consume() throws Exception{
        return queue.take();
    }    
    
    @Override
    public void run(){
        Thread t = Thread.currentThread();
        try{
            while(true){
                Thread.sleep(100);
                System.out.println(t.getName()+", consumed : "+this.consume());                
            }            
        }catch(Exception e){
            e.printStackTrace();
        }    
    }
}
