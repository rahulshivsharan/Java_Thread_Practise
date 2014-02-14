/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thread.queue;


public class Producer extends Thread{
    
    private volatile BlockingQueue queue;
    
    private int i =0;
    
    public Producer(String name,BlockingQueue queue){
        this.setName(name);
        this.queue = queue;
    }
    
    private void generate() throws Exception{
        queue.put(++i);
    }
    
    @Override
    public void run(){
        try{
            while(true){
                Thread.sleep(500);
                generate();
            }            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
