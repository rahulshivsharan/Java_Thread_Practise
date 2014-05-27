
package com.future.two;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MyFutureTestThree {

    public static void main(String[] args) {
        ExecutorService exec_Service = null;
        List<Future<Integer>> futureList = null;
        Integer sumTotal = 0;
        try {
            futureList = new ArrayList<Future<Integer>>();
            exec_Service = Executors.newFixedThreadPool(10);
            for (int x = 0; x < 5; x++) {
                Callable<Integer> myCallable = new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        Integer num = 0;
                        for (int n = 1; n <= 10; n++) {
                            if (n % 2 == 0) {
                                num += (n / 2);
                            }
                        }
                        return num;
                    }
                };
                Future<Integer> future = exec_Service.submit(myCallable);
                futureList.add(future);
            }

            for (Future<Integer> f : futureList) {
                sumTotal += f.get();
            }

            System.out.println(sumTotal);
            exec_Service.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
