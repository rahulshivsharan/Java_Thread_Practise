/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.waitSix;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

    public static void main(String[] args) {
        SharedResource res = null;
        MyPrintReq[] numStreams = null; 
        try {
            res = new SharedResource();
            numStreams = new MyPrintReq[]{
                new MyPrintReq(new int[]{2, 5, 7, 8}, res,"TOM"),
                new MyPrintReq(new int[]{1, 6, 9, 10}, res,"SAM"),
                new MyPrintReq(new int[]{3, 12, 14, 16}, res,"NICK"),
                new MyPrintReq(new int[]{4, 11, 15, 19}, res,"JOE"),
                new MyPrintReq(new int[]{13, 17, 20, 22}, res,"JACK"),
                new MyPrintReq(new int[]{18, 21, 23, 24}, res,"NEOMI")
            };
            
            for(Thread t : numStreams){
                t.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
