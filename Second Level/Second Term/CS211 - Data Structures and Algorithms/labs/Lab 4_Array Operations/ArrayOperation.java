package lab4_array;

public class ArrayOperation {

	private static final Object EMPTY = -1;
	
	public static void deleteElement(Object a[], int index)
	{
		if(index < 0 || index > (a.length-1) ) return;
		
		int i = 0;
		
		for(i=index;i<a.length;i++)
		{
			int j=i+1;
			
			if(j < a.length) {
				
				if(a[j] != EMPTY)
					a[i] = a[j];
				else
					break;
			} else {
				break;
			}
		}
		
		while(i < a.length) {
			a[i] = EMPTY;
			i++;
		}
		
		print(a);
	}
	
	public static void insertElement(Object[] a, int index, Object value)
	{
		if(index < 0 || index > (a.length-1) ) return;
		
		Object[] b = new Object[a.length];
		int last = a.length - 1;
		
		System.arraycopy(a,0,b,0,index);
		b[index]=value;
		System.arraycopy(a,index,b,index+1,last - index);
		print(b);
	}
	
	public static void print(Object[] a)
	{
		for(int i=0;i<a.length;i++)
			  System.out.print(a[i] + " ");
		  
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		
		Object a[] = {1,2,3,4,5};
		print(a);
		deleteElement(a,3);
		deleteElement(a,1);
		deleteElement(a,2);
		deleteElement(a,0);
		deleteElement(a,0);
		insertElement(a,1,2);
		
	}

}
