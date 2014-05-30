/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forkjoin;

import java.util.concurrent.RecursiveTask;


public class PartialSumTask extends RecursiveTask<Integer>{

    private int xNum;
    
    public PartialSumTask(int j){
        this.xNum = j;
    }
    
    @Override
    public Integer compute() {
        int num = 0;
        try{
            for(int i=1; i<= this.xNum; i++){
                num += i;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return num;
    }
    
}
