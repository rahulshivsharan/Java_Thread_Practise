
class MyThread extends Thread{
	
	private int toPrint;
	private MorganProblem01 myInstance; 
	
	MyThread(String str,int toPrint,MorganProblem01 myInstance){
		this.setName(str); // Thread Name
		this.toPrint = toPrint; // Which number the Thread is going to print
		this.myInstance = myInstance; // The object responsible to print the number
	}
	
	@Override
	public void run(){
		int i=0;
		try{
			while(i < 50){
				this.myInstance.printNum(toPrint);
				i++;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

public class MorganProblem01{

	private static volatile int counter;

	// This method is responsible to print the number passed from the calling thread.
	public synchronized void printNum(int num) throws Exception{
		boolean isPrinted = false;
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
				this.notifyAll();
			}else{
				this.notifyAll();
				this.wait();
			}
		}while(!isPrinted);		
	}

	// Main method which is run from command line
	public static void main(String [] args){
		try{
			MorganProblem01 p = new MorganProblem01();
			MyThread[] threads = new MyThread[]{
				new MyThread("T-ONE",1,p),
				new MyThread("T-TWO",2,p),
				new MyThread("T-THREE",3,p)
			};
			
			for(int i=0; i < threads.length; i++){
				threads[i].start();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
