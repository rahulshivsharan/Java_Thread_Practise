/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conprod;

import java.util.concurrent.BlockingQueue;


public class Producer implements Runnable {

    private BlockingQueue<Integer> buffer;

    public Producer(BlockingQueue<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        boolean flag = true;
        try {
            for (int x = 1; x <= 20; x++) {
                Thread.sleep(50);
                System.out.println("PRODUCER " + x);
                flag = true;
                
                while (flag) {
                    if (buffer.remainingCapacity() > 0) {
                        buffer.put(x);
                        flag = false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
