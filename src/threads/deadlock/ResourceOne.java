/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads.deadlock;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ResourceOne {
    
    public synchronized void callOne(ResourceTwo r2) throws Exception{
        Thread t = Thread.currentThread();    
        for(int x=1;x <=3; x++){
            System.out.println(t.getName()+", callOne "+x);
            if(x == 2){
                r2.callTwo();
            }
        }
    }
    
    public synchronized void pollTwo() throws Exception{
        Thread t = Thread.currentThread();    
        for(int x=1;x <=3; x++){
            System.out.println(t.getName()+", pollTwo "+x);            
        }
    }
}
