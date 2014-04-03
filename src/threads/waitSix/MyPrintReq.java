/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads.waitSix;


public class MyPrintReq extends Thread{

    public MyPrintReq(int[] nums, SharedResource res,String name){
        this.nums = nums;
        this.res = res;
        this.setName(name);
    }
    
    private int[] nums;
    private SharedResource res;
    
    @Override
    public void run() {
        try{
            for(int x=0;x < nums.length; x++){
                
                while(!res.printNum(nums[x], (x == (nums.length - 1) ? true : false))){
                    //System.out.println(Thread.currentThread().getName()+" waiting.....");
                }
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
