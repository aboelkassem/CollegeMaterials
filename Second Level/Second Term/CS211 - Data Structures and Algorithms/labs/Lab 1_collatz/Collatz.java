package lec1_collatz;

public class Collatz {

	// Attributes
	private static final int maxN = 17, maxCount = 100;
	private static StringBuffer sequence = null;
	
	// Methods
	private static boolean isTerminated(int n) {
		
		int count = 0, m = n;
		sequence = new StringBuffer();
		storeElement(m);
		
		
		if(n >= 1 && n <= 2) 
		{	
			for(int i=1;i<=n;i++)
			{
				m = step(m);
				storeElement(m);
			}
		}
			
		while(m != 1 && count < maxCount) {
			m = step(m);
			count++;
			storeElement(m);
		}
		
		return count < maxCount;
	}
	
	private static int step(int m) {
		if (m % 2 == 0) return m/2;
		return 3 * m + 1;
	}
	
	private static void storeElement(int m)
	{
		sequence.append(m);
		sequence.append(",");
	}
	
	private static void printSequence(String message)
	{
		System.out.println(sequence.toString() + " -> " + message);
	}
	
	public static void main(String[] args) {
		
		for(int n = 0; n <= maxN; n++) {
			if (!isTerminated(n)) {
				printSequence("Not terminated");
			} else {
				printSequence("Terminated");
			}
		}

	}

}
