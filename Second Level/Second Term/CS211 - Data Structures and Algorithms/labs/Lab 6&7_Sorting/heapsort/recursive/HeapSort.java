package lab5_sort.heapsort.recursive;

import lab5_sort.heapsort.util.Helper;

public class HeapSort {

    public static void heapsort(Integer[] array){
		
    	// Building a heap
		System.out.println("Building a heap:");
		Helper.printHeader();
		Helper.printArrayIndices("%1$15s", "Idx:", array);
		Helper.printArrayValues( "%1$15s", "Val:", array);
		System.out.println("   ==================================================");
		
   	 	buildHeap(array);
   	 	
   	    // Show the heap.
   	    System.out.println("===================================================================");
		System.out.println("The heap is shown below.");
		Helper.printArrayValues("%1$14s", "Heap:", array);
		Helper.printHeap(array,0);
		System.out.println("===================================================================");
		
		// Sort the array by shrinking the heap
		System.out.println("Sorting the array by shrinking the heap.");
		Helper.printHeader();
		Helper.printArrayIndices("%1$15s", "Idx:", array);
		Helper.printArrayValues( "%1$15s", "Val:", array);
		System.out.println("   ==================================================");
		
		int m = array.length;
		
		for (int i = array.length - 1; i >= 0; i--) {
		    swap(array, 0, m-1);
		    Helper.printArrayValues( "%1$15s", "Shrink:", array);
			System.out.println("   ssssssssssssssssssssssssssssssssssssssssssssssssss");
			
		    m--;
		    push(array, m, 0);
		}
		
		System.out.println("===================================================================");
	}
    
    private static void buildHeap(Integer [] array) {
		
	    for (int i = array.length/2; i >= 0; i--) 
	    {
	    	push(array, array.length, i);
	    	System.out.println("   **************************************************");
	    }
	}
	
	private static void push(Integer[] array, int n, int p) {

		int c1=2*p+1;
		
		// Parent has no children
		if (c1 > n-1) return; 
		
		// Parent has one child only
		if (c1 == n-1) {
		    if (array[p] >= array[c1]) return;
		    
		    swap(array, p, c1); // push down one level
		    
		    Helper.printHeapStepByStep(c1, p, array);
		    
		    push(array, n, c1); // push again (unnecessary)
		    return;
		}
		
		// Parent has two children: if parent has two children, then choose the largest child
		int cMax;
		int c2=2*p+2;
		
		if (array[c1] > array[c2]) cMax = c1;
		else cMax = c2; // A[j] is the larger child
		
		if (array[p] >= array[cMax]) return;
		
		swap(array, p, cMax); // push down one level
		
		Helper.printHeapStepByStep(cMax, p, array);
		
		push(array, n, cMax); // push again
		
		return;

	}
	
	private static void swap(Integer[] A, int i, int j)
	{
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static void main(String[] args) {
		
		Integer[] array = {1,3,5,6,2,4,8,7};
		//Integer[] array = {1,2,3,4,5};
		//Integer[] array = {1,2,3,4};
		//Integer[] array = {25,40,35,10,50};
//		Integer[] array = {63,51,20,40,45,5,2,7,4,42,1,3,25};
		//Integer[] array = {5,51,25,40,45,20,2,7,4,42,1,3};
		//Integer[] array = {10,22,50,55,32,44,81,72};
		
		System.out.println("At the beginning, we have the following array.");
		Helper.printArrayIndices("%1$14s", "Index:", array);
		Helper.printArrayValues("%1$14s", "Value:", array);
		System.out.println("===================================================================");
				
		heapsort(array);
				
		System.out.println("The sorted array is shown below.");
		Helper.printArrayValues("%1$14s", "Sort:", array);
	}

}
