
package com.future.one;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MainTest {
    public static void main(String [] args){
        ExecutorService service = null;
        Future<String> future = null;
        Callable<String> myCallable = null;
        try{
            myCallable = new MyCallable();
            service = Executors.newFixedThreadPool(10);
            future = service.submit(myCallable);
            
            while(!future.isDone()){
                System.out.println("Loading");
            }
            System.out.println(future.get());
            service.shutdown();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
