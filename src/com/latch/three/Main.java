/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.latch.three;

import java.util.concurrent.CountDownLatch;


public class Main {
    public static void main(String [] args){
        MyThread[] threads = null;
        SharedResource res = null;
        CountDownLatch latch = null;
        try{
            latch = new CountDownLatch(5);
            res = new SharedResource(latch);
            threads = new MyThread[]{
                new MyThread("TOM",res),
                new MyThread("JERRY",res),
                new MyThread("MICKEY",res),
                new MyThread("DONALD",res),
                new MyThread("BUNNY",res)
            };
            
            for(MyThread t : threads){
                t.start();
            }
            latch.await();
            System.out.println("All the services have completed");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
