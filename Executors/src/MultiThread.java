
public class MultiThread implements Runnable {

	
	private String threadNumber;
	
	public MultiThread(String threadNumber) {
        this.threadNumber = threadNumber;
    }
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Thread Number = " + threadNumber);
		getNumber();
		
	}

	private void getNumber() {
		
		 try {
	            Thread.sleep(500);
	        }
	        catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
}


