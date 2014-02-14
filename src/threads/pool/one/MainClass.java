/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads.pool.one;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class MainClass {
    public static void main(String [] args){
        ExecutorService service = Executors.newFixedThreadPool(5);
        try{
            for(int x=0;x < 20; x++){
                service.execute(new MyRunnable());                
            }
            service.shutdown();           
        }catch(Exception e){
            e.printStackTrace();
        }   
    }
}
