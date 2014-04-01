/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.latch.three;


public class MyThread extends Thread{
    
    private SharedResource resource;
    
    public MyThread(String name, SharedResource resource){
        setName(name);
        this.resource = resource;
    }
    
    @Override
    public void run(){
        try{
            this.resource.doIt();            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
