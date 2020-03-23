package lab5_sort.heapsort.util;

public class Helper {
	
	// Array
	
	public static <T extends Comparable<T>> void printArrayValues(String format, String note, T[] array)
	{
		if(note != null)
			System.out.format(format, note);
			
		for(int i=0;i<array.length;i++) {
			
			if(i==0)
				System.out.print("\t{"+array[0]);
			else
				System.out.format("%1$4d",array[i]);
		}
		
		if(array.length < 1)	
			System.out.println("{}");
		else
			System.out.println("}");
	}
	
	public static <T extends Comparable<T>> void printArrayIndices(String format, String note, T[] array)
	{
		if(note != null)
			System.out.format(format, note);
			
		for(int i=0;i<array.length;i++) {
			
			if(i==0)
				System.out.print("\t{0");
			else
				System.out.format("%1$4d",i);
		}
		
		if(array.length < 1)	
			System.out.println("{}");
		else
			System.out.println("}");
	}
	
	public static void printHeader()
	{
		System.out.format("%1$4s %2$4s \n", "c","p");
		
	}
	
	// Heap
	public static <T extends Comparable<T>> void printHeapStepByStep(int childIdx, int parentIdx, T[] array)
	{
		System.out.format("%1$4d %2$4d", childIdx,parentIdx);
		printArrayValues(null, null,array);
	}
	
	public static <T extends Comparable<T>> void printHeap(T[] array, int parentIdx)
	{
		if(parentIdx < 0 || parentIdx >= array.length) 
			return;
		
		int childIdx1 = 2*parentIdx + 1;
		int childIdx2 = -1;
		
		if(childIdx1 >= array.length) 
			return;
		
		System.out.format("%1$16s","parent=");
		System.out.format("%1$3d", array[parentIdx]);
		System.out.print(" -> children={");
					
		if(childIdx1 >= 0 && childIdx1 < array.length) {
			System.out.print(array[childIdx1]+" ");
			childIdx2 = 2*parentIdx + 2;
			
			if(childIdx2 >= 0 && childIdx2 < array.length)
				System.out.print(array[childIdx2] + "}\n");
			else
				System.out.print("}\n");
		} else {
			System.out.print("}\n");
		}
		
		printHeap(array, childIdx1);
		printHeap(array, childIdx2);
	}
	
	// Heap sort
	public static void printHeapSortHeader()
	{
		System.out.format("%1$5s %2$4s %3$4s %4$12s \n", "max_c", "p", "n", "operation");
	}
	
	public static <T extends Comparable<T>> void printHeapSortStepByStep(int childIdx, int parentIdx, int n, String operation, T[] array)
	{
		System.out.format("%1$5d %2$4d %3$4d %4$12s", childIdx,parentIdx,n, operation);
		printArrayValues(null,null,array);
	}
}
