/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads.pool;


public class Task {
    private String taskId;
    
    public Task(String taskId){
        this.taskId = taskId;
    }
    
    public String doWork(){
        return "Work done. Task Completion Id is "+this.getTaskId();
    }

    /**
     * @return the taskId
     */
    public String getTaskId() {
        return taskId;
    }
}
