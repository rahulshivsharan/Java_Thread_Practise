/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads.deadlock;


public class ReqThread extends Thread{
    
    private ResourceOne r1;
    private ResourceTwo r2;
    
    public ReqThread(String name,ResourceOne r1,ResourceTwo r2){
        this.setName(name);
        this.r1 = r1;
        this.r2 = r2;
    }
    
    
    
    @Override
    public void run(){
        try{
            if("T-ONE".equals(this.getName())){
                r1.callOne(r2);
            }else{
                r2.pollOne(r1);
            }            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
