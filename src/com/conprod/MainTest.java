
package com.conprod;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MainTest {
    public static void main(String [] args){
        BlockingQueue<Integer> q = null;
        ExecutorService service = null;
        try{
            q = new ArrayBlockingQueue<Integer>(4);
            service = Executors.newFixedThreadPool(2);
            service.execute(new Producer(q));
            service.execute(new Consumer(q));  
            
            service.shutdown();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
