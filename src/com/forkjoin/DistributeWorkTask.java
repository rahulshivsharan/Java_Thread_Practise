
package com.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;


public class DistributeWorkTask extends RecursiveTask<Integer>{

    private int partialSum =0;
    
    public DistributeWorkTask(int x){
        this.partialSum = x;
    }
    
    @Override
    public Integer compute() {
        int result = 0;
        List<RecursiveTask<Integer>> workerTasks = null;
        try{
            workerTasks = new ArrayList<RecursiveTask<Integer>>();
            
            for(int z=1;z <= this.partialSum; z++){
                PartialSumTask task = new PartialSumTask(z);
                task.fork();
                workerTasks.add(task);
            }
            
            for(RecursiveTask<Integer> myTask : workerTasks){
//                System.out.println(" --> "+myTask.join());
                result += myTask.join();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
}
