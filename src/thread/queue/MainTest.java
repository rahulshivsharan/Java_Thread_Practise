/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thread.queue;


public class MainTest {
    public static void main(String [] args){
        BlockingQueue q = new BlockingQueue();
        Producer [] producers = null;
        Consumer consumer = null;
        try{
           producers = new Producer[]{
               new Producer("P-1", q),
               new Producer("P-2", q),
               new Producer("P-3", q)
           };
           
           consumer = new Consumer("CON", q);
           consumer.start();
           for(Producer p : producers){
               p.start();
           }
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
