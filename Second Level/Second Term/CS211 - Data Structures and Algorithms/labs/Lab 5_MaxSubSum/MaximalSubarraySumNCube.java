package lab4_array.msm;

public class MaximalSubarraySumNCube {
	
	public static int findMaxSubSum(int[] a )
	{
		 int start = 0;
		 int end = -1;
	     int maxSum = 0;
	     
	     for( int i = 0; i < a.length; i++ )
	         for( int j = i; j < a.length; j++ )
	         {
	             int thisSum = 0;
	             
	             for( int k = i; k <= j; k++ )
	                 thisSum += a[k];
	             
	             if( thisSum > maxSum )
	             {
	                 maxSum   = thisSum;
	                 start = i;
	                 end   = j;
	             }
	         }
	     return maxSum;
	}
		
	public static void main(String[] args) {
	
		int[] a = {1,-2,3,2,-1,1,-1,4,-2,5,-3,2,-1,1};
		int maxSum = findMaxSubSum(a);

		System.out.println("Max Subarray Sum="+maxSum);
	}

}
