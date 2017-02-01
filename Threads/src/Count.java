
public class Count implements Runnable {

	Thread newThread;
	
	Count() {
		
		newThread = new Thread(this, "Numbers");
		System.out.println(newThread + "was Created");
		
		newThread.start();
		System.out.println(newThread + "was Started");
	}
	public void run() {

		try {
			int even = 2;
			for(int i =1; i<12;i++)  {
				if (i % even == 0) {
					System.out.println(i + " is an even number");
					Thread.sleep(1000);      } 
				else {
					System.out.println(i + " is an odd number");
					Thread.sleep(1000); }
				
			                          }
		    }
		catch(InterruptedException e)
		{
			System.out.println("Twas Interrupted");
		}
		System.out.println("The Thread has finished");
	                 }

}
