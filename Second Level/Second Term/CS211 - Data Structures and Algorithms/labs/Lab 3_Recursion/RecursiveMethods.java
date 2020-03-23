/* A class for recursive methods
   @author Koffman and Wolfgang
 */

package lab6_recursive;

public class RecursiveMethods {
	
	/** Recursive method to calculate Fibonacci numbers
    (in RecursiveMethods.java).
    pre: n >= 1
    @param n The position of the Fibonacci number being calculated
    @return The Fibonacci number
 */
	public static int fibonacci(int n) {
	  if (n <= 2)
	    return 1;
	  else
	    return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
/** Wrapper method for calculating Fibonacci numbers
	    (in RecursiveMethods.java).
	    pre: n >= 1
	    @param n The position of the desired Fibonacci number
	    @return The value of the nth Fibonacci number
	 */
	public static int fibonacciStart(int n) {
	  return fibo(1, 0, n);
	}

	/** Recursive O(n) method to calculate Fibonacci numbers
	    (in RecursiveMethods.java).
	    pre: n >= 1
	    @param fibCurrent The current Fibonacci number
	    @param fibPrevious The previous Fibonacci number
	    @param n The count of Fibonacci numbers left to calculate
	    @return The value of the Fibonacci number calculated so far
	 */
	private static int fibo(int fibCurrent, int fibPrevious, int n) {
	
	  if (n == 1)
	    return fibCurrent;
	  else
	    return fibo(fibCurrent + fibPrevious, fibCurrent, n - 1);
	}
	
	
	
	/** Wrapper for recursive linear search method (in
    RecursiveMethods.java).
    @param items The array being searched
    @param target The object being searched for
    @return The subscript of target if found; otherwise �1
    */
	public static int linearSearch(Object[] items, Object target) {
	  return linearSearch(items, target, items.length);
	}

	/** Recursive linear search method (in RecursiveMethods.java).
	    @param items The array being searched
	    @param target The object being searched for
	    @param size The number of candidates left in the array
	    @return The subscript of target if found; otherwise �1
	 */
	private static int linearSearch(Object[] items,
	                                Object target, int size) {
	  if (size == 0) {
	    System.out.println("For index=-1, target="+target + " has not been found yet.");		
	    return -1;
	  } else if (target.equals(items[size - 1])) {
	    System.out.println("For items[" + (size-1) + "]=" + items[size-1] + ", target="+target + " is found.");	
	    return size - 1;
	  } else {
	    System.out.println("For items[" + (size-1) + "]=" + items[size-1] + ", target="+target + " has not been found yet.");	
	    return linearSearch(items, target, size - 1);
	  }
	}
	
	public static int linearSearch2(Object[] items, Object target) {
		  return linearSearch2(items, target, 0);
	} 
	
	private static int linearSearch2(Object[] items,
            Object target, int currentIndex) {
		
		if (currentIndex >= items.length) {
			System.out.println("For index=-1, target="+target + " has not been found yet.");		
			return -1;
		} else if (target.equals(items[currentIndex])) {
			System.out.println("For items[" + currentIndex + "]=" + items[currentIndex] + ", target="+target + " is found.");	
			return currentIndex;
		} else {
			System.out.println("For items[" + currentIndex + "]=" + items[currentIndex] + ", target="+target + " has not been found yet.");
			return linearSearch2(items, target, currentIndex+1);
		}
    }
	
	
	
  /** Recursive binary search method (in RecursiveMethods.java).
      @param items The array being searched
      @param target The object being searched for
      @param first The subscript of the first element
      @param last The subscript of the last element
      @return The subscript of target if found; otherwise -1.
   */
  private static int recursiveBinarySearch(Object[] items, Comparable target,
                                  int first, int last) {
    int middle = (first + last) / 2; // index for next probe
    System.out.print("middle="+middle);
    
    if (first > last)
      return -1; // base case for unsuccessful search
    else {
      int compResult = target.compareTo(items[middle]);
      if (compResult == 0)
        return middle; // base case for successful search
      else if (compResult < 0) {
    	System.out.println(", left=" + first + ", right="+ (middle-1));  
        return recursiveBinarySearch(items, target, first, middle - 1);
      } else {
    	System.out.println(", left=" + (middle + 1) + ", right="+last);    
        return recursiveBinarySearch(items, target, middle + 1, last);
      }
    }
  }

  /** Wrapper for recursive binary search method (in RecursiveMethods.java).
      @param items The array being searched
      @param target The object being searched for
      @return The subscript of target if found; otherwise -1.
   */
  public static int recursiveBinarySearch(Object[] items, Comparable target) {
	  System.out.println("RecursiveBinarySearch: Searching for the target " + target + " in a sorted array begins");  
	  System.out.println("RecursiveBinarySearch: At the beginning, left=" + 0 + ", right="+ (items.length-1));
	  return recursiveBinarySearch(items, target, 0, items.length - 1);
  }

  /** Recursive method length (in RecursiveMethods.java).
    @param str The string
    @return The length of the string
   */
  public static int length(String str) {
    if (str == null || str.equals(""))
      return 0;
    else
      return 1 + length(str.substring(1));
  }

  /** Recursive method printChars (in RecursiveMethods.java).
      POST: THE ARGUMENT STRING IS DISPLAYED, ONE CHARACTER
            per line.
      @param str The string
   */
  public static void printChars(String str) {
    if (str == null || str.equals("")) {
      return;
    }
    else {
      System.out.println(str.charAt(0));
      printChars(str.substring(1));
    }
  }

  /** Recursive method printCharsReverse (in RecursiveMethods.java).
      post: The argument string is displayed in reverse,
            one character per line.
      @param str The string
   */
  public static void printCharsReverse(String str) {
    if (str == null || str.equals("")) {
      return;
    }
    else {
      printCharsReverse(str.substring(1));
      System.out.print(str.charAt(0));
    }
  }

  /** Recursive factorial method (in RecursiveMethods.java).
      pre: n >= 0
      @param n The integer whose factorial is being computed
      @return n!
   */
  public static int factorial(int n) {
    if (n == 0)
      return 1;
    else
      return n * factorial(n - 1);
  }

  /** Recursive power method (in RecursiveMethods.java).
      pre: n >= 0
      @param x The number being raised to a power
      @param n The exponent
      @return x raised to the power n
   */
  public static double power(double x, int n) {
    if (n == 0)
      return 1;
    else
      return x * power(x, n - 1);
  }

  /** Recursive gcd method (in RecursiveMethods.java).
      pre: m > 0 and n > 0
      @param m The larger number
      @param n The smaller number
      @return Greatest common divisor of m and n
   */
  public static double gcd(int m, int n) {
    if (m % n == 0)
      return n;
    else if (m < n)
      return gcd(n, m); // Transpose arguments.
    else
      return gcd(n, m % n);
  }

  
}
