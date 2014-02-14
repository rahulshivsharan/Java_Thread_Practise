/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads.lock.one;

public class MyRequest extends Thread{
    private Resource res;
    
    public MyRequest(String name,Resource res){
        this.setName(name);
        this.res = res;
    }    
    
    @Override
    public void run(){
        try{
            res.resource();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
