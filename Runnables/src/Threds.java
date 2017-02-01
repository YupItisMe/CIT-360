
//Created by Josh Cunningham 2/1/2016 to test Runnables code
public class Threds implements Runnable {

	private Thread first;
	private String newName;
	
	// Default Constructor
	Threds(String name) {
		newName = name;
		System.out.println("Created " + newName);
	                 
	}
	public void run() {
		System.out.println("Running " + newName);
		
		try {
			for(int i =7; i>0; i--){
				System.out.println(newName + " will die in " + i);
				Thread.sleep(500);
			                       }
		    }
		catch(InterruptedException e) {
			System.out.println("Timer Interrupted");
		                              }
		System.out.println("Timer Finished");
	                  }
	
	public void start () {
        System.out.println("Starting " +  newName );
        if (first == null) {
            first = new Thread (this, newName);
            first.start ();
        }
	}
}
