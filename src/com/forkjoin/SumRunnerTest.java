
package com.forkjoin;

import java.util.concurrent.ForkJoinPool;


public class SumRunnerTest {
    public static void main(String[] args){
        int partialSumOf =3, partialSum=0;        
        ForkJoinPool pool = null;
        try{
            pool = new ForkJoinPool();
            partialSum = pool.invoke(new DistributeWorkTask(partialSumOf));
            System.out.println(partialSum);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
