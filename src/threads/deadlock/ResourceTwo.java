/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads.deadlock;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ResourceTwo {
    
    public synchronized void callTwo() throws Exception{
        Thread t = Thread.currentThread();    
        for(int x=1;x <=3; x++){
            System.out.println(t.getName()+", callTwo "+x);            
        }
    }
    
    public synchronized void pollOne(ResourceOne r1) throws Exception{
        Thread t = Thread.currentThread();    
        for(int x=1;x <=3; x++){
            System.out.println(t.getName()+", pollOne "+x);
            if(x == 2){
                r1.pollTwo();
            }
        }
    }
}
