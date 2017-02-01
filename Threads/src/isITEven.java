class isITEven {
	
	public static void main(String args[]) {
		Count first = new Count();
		
		try {
			while(first.newThread.isAlive()) {
				System.out.println("The Thread is Alive");
				Thread.sleep(1500); 
	          }
		    }
		catch(InterruptedException e) {
			System.out.println(first + "was Interrupted");
		                              }
	}
	
}