package lab5_sort.selectionsort;

public class SelectionSort {

	public static void sort (Comparable[] a) 
	{
		int left = 0;
		int right = a.length-1;
		
		for (int m = left; m < right; m++) {
			
			int p = m;		
			Comparable least = a[p];	
			
			for (int k = m+1; k <= right; k++) {
				
				int comp = a[k].compareTo(least);	
				
				if (comp < 0) { 
					p = k; 
					least = a[p]; 
				}		
		    }		
			
			if (p != m) { // swapping
				
				a[p] = a[m];
				a[m] = least;
			}
			
			for(int i=0;i<a.length;i++)
				  System.out.print(a[i] + " ");
			System.out.print("\n");
		}
		
	}

	public static void main(String[] args) {
		Integer[] a = {4,3,-1,8};
		sort(a);
		
		//for(int i=0;i<a.length;i++)
		//	  System.out.print(a[i] + " ");
		  
		//System.out.print("\n");

	}

}
