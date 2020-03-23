package lab5_sort.mergesort.slide;

import lab5_sort.mergesort.kw.ArrayPrinter;

public class MergeSort {

	public static void mergeSortSubArray(Comparable[] a, 
		 	int left, int right) {
		
	    if (left >= right) return; // nothing to sort
	    
	    int m = (left + right)/2; // find midpoint
	    
	    mergeSortSubArray(a, left, m); // sort left half
	    mergeSortSubArray(a,m+1, right); // sort right half
	    
	    Comparable[] temp = new Comparable[right - left + 1];
			
	    // merge sorted halves into temp and copy back to a
	    temp = merge(a, left, m, m+1, right, temp, 0);
	    
	    for (int i = 0; i < right - left + 1; i++) {
	          a[left + i] = temp[i];
	    }
	}
	
	private static Comparable[] merge(Comparable[] a, int left, int m, int m1, int right, Comparable[] temp, int start) {
		
		ArrayPrinter.printArray("a:",a);
		System.out.println("left="+left + " m="+m + " m1="+m1 + " right="+ right + " temp.len="+temp.length);
		
		int j=0;
		
		for(int i=left;i<=m;i++)
			temp[j++] = a[i];
		
		for(int i=m1;i<=right;i++)
			temp[j++] = a[i];
		
		ArrayPrinter.printArray("temp:",temp);
		return temp;
	}
	
	public static void main(String[] args) {
		Integer[] array = {5,3,9,2};
		mergeSortSubArray(array,0,3);
	    ArrayPrinter.printArray("final result:",array);

	}

}
