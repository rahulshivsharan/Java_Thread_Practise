/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thread.queue;


public class Consumer extends Thread{
    
    private volatile BlockingQueue queue;
    
    public Consumer(String name,BlockingQueue queue){
        this.setName(name);
        this.queue = queue;
    }
    
    private void consume() throws Exception{
        queue.get();
    }    
    
    @Override
    public void run(){
        try{
            while(true){
                Thread.sleep(500);
                this.consume();
            }            
        }catch(Exception e){
            e.printStackTrace();
        }    
    }
}
