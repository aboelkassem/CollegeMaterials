package lab5_sort.mergesort.kw;

public class ArrayPrinter {

	public static<T extends Comparable<T>> void printArray(String label, T[] array)
	  {
		  System.out.print(label);
		  
		  for(int i=0;i<array.length;i++)
			  System.out.print(array[i] + " ");
		  
		  System.out.print("\n");
		  
	  }
		
}
