package lab4_array.msm;

public class MaximalSubarraySumN {

	public static int findMaxSubSum(int[] a)
	{
		int start = 0;
		int end = -1;	
		int maxSum = 0;
		int thisSum = 0;
		
		for( int i = 0, j = 0; j < a.length; j++ )
		{
		    thisSum += a[j];
		    
		    if( thisSum > maxSum ) {
		    	
		        maxSum = thisSum;
		        start = i;
		        end   = j;
		        
		    } else if( thisSum < 0 ) {
		        i = j + 1;
		        thisSum = 0;
		    }
		}
		
		return maxSum;

	}
	
	public static void main(String[] args) {
		//int[] a = {1,-2,3,2,-1,1,-1,4,-2,5,-3,2,-1,1};
		//int[] a = {2,-1,3,2,-3};
		int[] a = {1,-2,3,2};
		int maxSum = findMaxSubSum(a);

		System.out.println("Max Subarray Sum="+maxSum);
	}
}
