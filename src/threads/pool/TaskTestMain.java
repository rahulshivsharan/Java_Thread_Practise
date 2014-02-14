/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class TaskTestMain {
    public static void main(String [] args){
        ExecutorService service = Executors.newFixedThreadPool(5);
        Long startTime = null;
        Long stopTime = null;
        try{
            startTime = System.currentTimeMillis();
            for(int x = 1; x <=10; x++){
                service.execute(new WrokerThread(new Task("TASK-"+x)));
            }
            service.shutdown();
            service.awaitTermination(1, TimeUnit.DAYS);
            stopTime = System.currentTimeMillis();
            System.out.println("Time taken to Complete "+(stopTime - startTime));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
