package lab5_sort.heapsort.iterative;

import lab5_sort.heapsort.util.Helper;


public class HeapSort {

	public static <T extends Comparable<T>> void sort(T[] array)
	{
		buildHeap(array, array.length-1);
		shrinkHeap(array);
	}
	
	public static <T extends Comparable<T>> void buildHeap(T[] array, int lastIndex)
	{
		Helper.printHeader();
		Helper.printArrayIndices("%1$15s", "Idx:", array);
		Helper.printArrayValues( "%1$15s", "Val:", array);
		System.out.println("   ==================================================");
		
		for(int childIdx=0; childIdx<=lastIndex; childIdx++)	{
			
			int parentIdx = (childIdx - 1)/2 ;
			
			while(parentIdx >= 0 && array[parentIdx].compareTo(array[childIdx]) < 0) {
				
				swap(array, parentIdx, childIdx);
				Helper.printHeapStepByStep(childIdx,parentIdx, array);
				
				childIdx = parentIdx;
				parentIdx = (childIdx-1)/2;
			} 
			
			if(childIdx == 1 && parentIdx == 0 && array[parentIdx].compareTo(array[childIdx]) >= 0)
				System.out.println("   **************************************************");
			
		}
	}
	
	public static <T extends Comparable<T>> void shrinkHeap(T[] array)
	{
		Helper.printArrayIndices("%1$15s", "Idx:", array);
		Helper.printArrayValues( "%1$15s", "Val:", array);
		System.out.println("   --------------------------------------------------");
		
		int n = array.length;
			
		while(n > 0) {		
			n--;
			swap(array,0,n); // sorting by shrinking the heap
			
			Helper.printArrayValues( "%1$15s", "Shrink:", array);
			System.out.println("   ssssssssssssssssssssssssssssssssssssssssssssssssss");
						
			buildHeap(array,n-1); // restore the heap
		}
	}
	
	public static <T extends Comparable<T>> void swap(T[] array, int parentIdx, int childIdx)
	{
		T temp = array[parentIdx];
		array[parentIdx] = array[childIdx];
		array[childIdx] = temp;
	}
	
	public static void main(String[] args) {
		
		//Integer[] array = {89,76,74,37,32,39,66,20,26,18,28,29,6};
		//Integer[] array = {3,6,4,7,5,2,9,8};
		//Integer[] array = {4,3,1,5,2};
		//Integer[] array = {1,3,5,6,2,4,8,7};
		Integer[] array = {1,2,3,4,5};
	
		System.out.println("At the beginning, we have the following array.");
		Helper.printArrayIndices("%1$14s", "Index:", array);
		Helper.printArrayValues("%1$14s", "Value:", array);
		System.out.println("===================================================================");
				
		// Building a heap
		System.out.println("Building a heap:");
		buildHeap(array, array.length-1);
		System.out.println("===================================================================");
		
		// Show the heap.
		System.out.println("The heap is shown below.");
		Helper.printArrayValues("%1$14s", "Heap:", array);
		Helper.printHeap(array,0);
		System.out.println("===================================================================");
		
		// Sort the array by shrinking the heap
		System.out.println("Sorting the array by shrinking the heap.");
		shrinkHeap(array);
		System.out.println("===================================================================");
		
		System.out.println("The sorted array is shown below.");
		Helper.printArrayValues("%1$14s", "Sort:", array);
		
	}

}
