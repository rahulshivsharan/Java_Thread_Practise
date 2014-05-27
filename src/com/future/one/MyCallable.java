
package com.future.one;

import java.util.concurrent.Callable;


public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {

        for (int j = 1; j < 10; j++) {
            Thread.sleep(50);
            System.out.println(Thread.currentThread().getName()+" :: "+j);
        }

        return "Callable done";
    }
}
