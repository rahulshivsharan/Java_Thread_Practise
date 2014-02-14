/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class MainThread {
    
    private static void callOne() throws Exception{
        SharedResourceOne res = new SharedResourceOne();
        MyRequest t1 = new MyRequest("MAN", res);
        MyRequest t2 = new MyRequest("WOMAN", res);
        t1.start();
        t2.start();
    }
    
    private static void callTwo() throws Exception{
        SharedResourceTwo res = new SharedResourceTwo();
        MyReqOne t1 = new MyReqOne("T-ONE", res, new int[]{2,4,6});
        MyReqOne t2 = new MyReqOne("T-ONE", res, new int[]{1,3,5,7});
        t1.start();
        t2.start();
    }
    
    public static void main(String [] args){
        try{
            //callOne();
            callTwo();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
