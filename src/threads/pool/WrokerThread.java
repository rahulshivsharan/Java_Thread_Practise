/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads.pool;


public class WrokerThread implements Runnable{

    private Task task;
    
    public WrokerThread(Task task){
        this.task = task;
    }
    
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        try{
            System.out.println(task.doWork()+" : "+t.getName());
            Thread.sleep(500);
        }catch(Exception e){
            e.printStackTrace();                    
        }
    }
    
}
