/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.pool.one;


public class MyRunnable implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(t.getName()+" : "+i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
