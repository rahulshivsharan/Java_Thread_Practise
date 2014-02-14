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
public class Producer extends Thread{
    
    private volatile BlockingQueue<Integer> queue;
    
    private int i =0;
    
    public Producer(String name,BlockingQueue queue){
        this.setName(name);
        this.queue = queue;
    }
    
    private void generate(int num) throws Exception{
        queue.put(num);
    }
    
    @Override
    public void run(){
        Thread t = Thread.currentThread();
        try{
            while(i<20){
                Thread.sleep(1000);
                i++;
                System.out.println(t.getName()+", produced "+i);
                generate(i);
            }            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
