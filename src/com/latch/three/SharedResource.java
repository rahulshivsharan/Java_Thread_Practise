/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.latch.three;

import java.util.concurrent.CountDownLatch;


public class SharedResource {
    
    private CountDownLatch latch;
    
    public SharedResource(CountDownLatch latch){
        this.latch = latch;
    }
    
    public void doIt() throws Exception{        
        System.out.println("THREAD : "+Thread.currentThread().getName()+" is running ......");        
        this.latch.countDown();
    }
    
    
}
