/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.pool.two;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

    private static final int COUNT = 6;

    public static void main(String[] args) {
        SharedResource res = null;
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(COUNT);
            res = new SharedResource();

            service.execute(new MyPrintReq(new int[]{2, 5, 7, 8}, res));
            service.execute(new MyPrintReq(new int[]{1, 6, 9, 10}, res));
            service.execute(new MyPrintReq(new int[]{3, 12, 14, 16}, res));
            service.execute(new MyPrintReq(new int[]{4, 11, 15, 19}, res));
            service.execute(new MyPrintReq(new int[]{13, 17, 20, 22}, res));
            service.execute(new MyPrintReq(new int[]{18, 21, 23, 24}, res));
            service.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
