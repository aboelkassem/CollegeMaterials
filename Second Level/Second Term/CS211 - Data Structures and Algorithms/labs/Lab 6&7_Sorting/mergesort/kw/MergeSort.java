package lab5_sort.mergesort.kw;



public class MergeSort {

  // Koffman and Wolfgang pp. 539
  public static<T extends Comparable<T>> void sort(T[] array)
  {
	  if(array.length > 1) {
		  
		  int half = array.length/2;
		  T[] leftArray  = (T[])new Comparable[half];
		  T[] rightArray = (T[]) new Comparable[array.length-half];
		  
		  System.arraycopy(array,0,leftArray,0,half);
		  System.arraycopy(array,half,rightArray,0,array.length-half);
		  
		  ArrayPrinter.printArray("divide_array: left array :",leftArray);
		  ArrayPrinter.printArray("divide_array: right array:",rightArray);
		  
		  sort(leftArray); 	// recursive operation on the left array (the first half)
		  sort(rightArray); // recursive operation on the right array (the second half)
		  
		  // After returning from the recursive operation, sort each two-array elements
		  MyMerging.merge(array,leftArray,rightArray);
	  }
  }
  
    
  public static void main(String[] args) {
		// TODO Auto-generated method stub

	    Integer[] array = {5,3,9,2,7};
	    sort(array);
	    ArrayPrinter.printArray("final result:",array);
	  
  }

}
