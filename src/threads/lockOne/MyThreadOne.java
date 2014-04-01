/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads.lockOne;


public class MyThreadOne extends Thread{
    
    private SharedResource res;
    private  int num;
    
    public MyThreadOne(String name,SharedResource res,int num){
        this.setName(name);
        this.res = res;
        this.num = num;
    }
    
    @Override
    public void run(){
        try{
            res.counter(num);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String [] args){
        try{
            SharedResource res = new SharedResource();
            MyThreadOne t1 = new MyThreadOne("JACK",res,4);
            MyThreadOne t2 = new MyThreadOne("JILL",res,5);
            
            t1.start();
            t2.start();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
