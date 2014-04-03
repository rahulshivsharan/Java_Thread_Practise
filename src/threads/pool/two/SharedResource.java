/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.pool.two;


public class SharedResource {

    private volatile int counter = 1;

    public synchronized boolean printNum(int num, boolean isLastNum) throws Exception {
        boolean printed = false;
        if (num == counter) {
            System.out.println(Thread.currentThread().getName() + " " + num);
            counter++;
            printed = true;
            if (isLastNum) {
                this.notifyAll();
            }
        } else {
            printed = false;
            this.notifyAll();
            this.wait();
        }

        return printed;
    }
}
