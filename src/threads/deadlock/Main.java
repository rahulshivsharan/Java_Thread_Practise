/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads.deadlock;


public class Main {
    public static void main(String [] args){
        ResourceOne r1 = new ResourceOne();
        ResourceTwo r2 = new ResourceTwo();
        
        ReqThread t1 = new ReqThread("T-ONE", r1,r2);
        ReqThread t2 = new ReqThread("T-TWO",r1 ,r2);
        
        t1.start();
        t2.start();
    }
}
