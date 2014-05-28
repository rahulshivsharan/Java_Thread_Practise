
package com.conprod;

import java.util.concurrent.BlockingQueue;


public class Consumer implements Runnable{

    private BlockingQueue<Integer> buffer;
    
    public Consumer(BlockingQueue<Integer> queue){
        this.buffer = queue;
    }
    
    @Override
    public void run() {
       try{
           do{
               System.out.println(" COMSUMER "+buffer.take());
               Thread.sleep(1000);
           }while(!buffer.isEmpty());
       }catch(Exception e){
           e.printStackTrace();
       } 
    }
    
}
