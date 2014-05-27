
package com.future.two;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MyFutureTestTwo {
    public static void main(String [] args){
        Callable<Integer> myCallable = null;
        ExecutorService exec_Service = null;
        Future<Integer> future = null;
        try{
            exec_Service = Executors.newFixedThreadPool(10);
            myCallable = new Callable<Integer>() {

                @Override
                public Integer call() throws Exception {
                    Integer total = 0;
                    for(int i = 1; i <= 10; i++){
                        Thread.sleep(250);
                        if(i%2 ==0){
                            total += (i/2);
                        }
                    }
                    return total;
                }
            };
            future = exec_Service.submit(myCallable);
            while(!future.isDone()){
                System.out.println(".");
            }
            System.out.println(future.get());
            System.out.println("Done .......");
            exec_Service.shutdown();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
