package lab5_sort.insertionsort;

public class InsertionSort {

	public static void sort (Comparable[] a) 
	{
		for(int r=1;r<a.length;r++) {
			
			Comparable value = a[r];
			int pos = r;
			
			while(pos > 0 && value.compareTo(a[pos-1]) < 0) {
				
				a[pos] = a[pos-1]; // shift the element which is larger than value to the right
				pos--;
			}
			
			a[pos]=value; // insert the value at the right position.
				
		}
	}
	
	public static void main(String[] args) {
		
		Integer[] a = {2,1,5,4,3};
		sort(a);
		
		for(int i=0;i<a.length;i++)
			  System.out.print(a[i] + " ");
		  
		System.out.print("\n");
	}

}
