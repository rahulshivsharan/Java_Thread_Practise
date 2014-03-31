/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.waitFive;




public class SharedResource {

   

    public synchronized void counter(int num) throws Exception {
        
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + " Acess... ");
            
            for (int x = 1; x <= 10; x++) {
                System.out.println(t.getName() + " : " + x);
                if (num == x) { 
                    this.notifyAll();
                    this.wait();
                }
            }
            this.notifyAll();
    }
}
