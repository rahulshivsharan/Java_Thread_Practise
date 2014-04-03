/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.pool.two;


public class MyPrintReq implements Runnable {

    public MyPrintReq(int[] nums, SharedResource res) {
        this.nums = nums;
        this.res = res;
    }
    private int[] nums;
    private SharedResource res;

    @Override
    public void run() {
        try {
            for (int x = 0; x < nums.length; x++) {

                while (!res.printNum(nums[x], (x == (nums.length - 1) ? true : false))) {
//                    System.out.println(Thread.currentThread().getName()+" waiting.....");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
