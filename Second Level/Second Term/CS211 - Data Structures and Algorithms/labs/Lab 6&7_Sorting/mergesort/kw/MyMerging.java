package lab5_sort.mergesort.kw;


public class MyMerging {

	// Koffman and Wolfgang pp. 536
	public static <T extends Comparable<T>> void merge(T[] outputArray, T[] leftArray, T[] rightArray)
	{
		int i=0; // left array index
		int j=0; // right array index
		int k=0; // output array index
		
		while (i < leftArray.length && j < rightArray.length) {
			
			if(leftArray[i].compareTo(rightArray[j]) <= 0)
				outputArray[k++] = leftArray[i++];
			else 
				outputArray[k++] = rightArray[j++];			
		}
		
		while(i < leftArray.length)
			outputArray[k++] = leftArray[i++];
		
		while(j < rightArray.length)
			outputArray[k++] = rightArray[j++];
		
		ArrayPrinter.printArray("merge_array: left array :",leftArray);
		ArrayPrinter.printArray("merge_array: right array:",rightArray);
		ArrayPrinter.printArray("merge_array: output array:",outputArray);
	}
}
