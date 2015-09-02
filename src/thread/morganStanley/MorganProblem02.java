
class MyThread extends Thread{
	
	private int toPrint;
	 
	
	MyThread(String str,int toPrint){
		this.setName(str); // Thread Name
		this.toPrint = toPrint; // Which number the Thread is going to print		
	}
	
	@Override
	public void run(){
		int i=0;
		try{
			while(i < 50){
				MorganProblem02.printNum(this.toPrint);
				i++;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

public class MorganProblem02{

	private static volatile int counter;
	private static Object lock = new Object();
	
	// This method is responsible to print the number passed from the calling thread.
	public static void printNum(int num) throws Exception{
		boolean isPrinted = false;
		
		synchronized(lock){
			do{
				if((num - 1) == counter){
					System.out.print(num+" ");
					isPrinted = true;
					
					if(num == 3){
						counter = 0;
						System.out.print("\n");
					}else{
						counter = num;	
					}
					lock.notifyAll();
				}else{
					lock.notifyAll();
					lock.wait();
				}
			}while(!isPrinted);
		}
				
	}

	// Main method which is run from command line
	public static void main(String [] args){
		try{
			
			MyThread[] threads = new MyThread[]{
				new MyThread("T-ONE",1),
				new MyThread("T-TWO",2),
				new MyThread("T-THREE",3)
			};
			
			for(int i=0; i < threads.length; i++){
				threads[i].start();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
