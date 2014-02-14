/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads.lock.one;


public class MyReqOne extends Thread{
    
    public MyReqOne(String name,SharedResourceTwo res,int [] nums){
        this.setName(name);
        this.nums = nums;
        this.res = res;
    }
    
    private int [] nums;
    private SharedResourceTwo res;
    
    @Override
    public void run(){
        try{
            for(int x=0; x < nums.length; x++){
                res.resource(nums[x]);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
}
