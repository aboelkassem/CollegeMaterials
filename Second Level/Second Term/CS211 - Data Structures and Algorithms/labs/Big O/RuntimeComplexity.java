package lec2_complexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RuntimeComplexity {

	private final int smallN=3;
	private final int bigN=100;
	private final int veryBigN=1000000000;
	
	private int count = 0;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	
	public void showExample1()
	{
		System.out.println("Example 1: O(n)");
		count = 0;
		
		for (int i = 0; i < smallN; i++) {
				System.out.println("i = " + i);
				count++;
		}
		
		System.out.println("For n=" + smallN + ", the iteration count = " + count);
	}
	
	public void showExample2()
	{
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Example 2: O(n^2)");
		count = 0;
		
		for (int i = 0; i < smallN; i++) {
			for (int j = 0; j < smallN; j++) {
				System.out.println("i = " + i + " ; j=" + j);
				count++;
			}
		}
		
		System.out.println("For n=" + smallN + ", the iteration count = " + count);
	}
	
	public void showExample3()
	{
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Example 3: O(n)");
		count=0;
		
		for(int i = 0; i < smallN*smallN ; i++)
		{
			System.out.println("i=" + i);
			count++;
		}
		
		System.out.println("For n=" + smallN + ", the iteration count = " + count);
	}
	
	public void showExample4()
	{
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Example 4: log(n)");
		count=0;
		
		for (int i = bigN; i > 0; i = i/2) {
			System.out.println("i = " + i + " ; \t i/2=" + (i/2));
			count++;
		}
		
		System.out.println("For n=" + bigN + ", the iteration count = " + count);
		
		/*
		int i = bigN;
		
		while (i > 0) {
			i = i/2;
		}
		*/
	}
	
	public void repeatExample4()
	{
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Repeat example 4 (i/2): Repeat on the factor of 10");
		
		for(int n=1;n<=veryBigN;n=n*10)
		{
			count=0;
			
			for (int i = n; i > 0; i = i/2) {
				count++;
			}
			
			System.out.println("For n=" + n + ", it-count=" + count);
		}
	}
	
	public void showExample5()
	{
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Example 5: O(sqrt(n))");
		count=0;
		
		for (int i = 0; i*i < bigN; i++) {
			System.out.println("i = " + i + " ; \t i^2=" + (i*i));
			count++;
		}
		
		System.out.println("For n=" + bigN + ", the iteration count = " + count);
		
		/*
		int i=0;
		while( (i*i) < bigN)
		{
			i++;
		}
		*/
	}
	
	public void repeatExample5()
	{
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Repeat example 5 (i*i): Repeat on the factor of 10");
		
		for(int n=1;n<=veryBigN;n=n*10)
		{
			count=0;

			for (int i = 0; i*i < n; i++) {
				count++;
			}
			
			System.out.println("For n=" + n + ", it-count=" + count);
		}
	}
	
	public void pause()
	{
		try {
			reader.readLine();	
		} catch(IOException ioe) {
			System.out.println("-E-:"+ ioe.getMessage());
		} 
	}
	
	public void close_stream()
	{
		try {
			reader.close();	
		} catch(IOException ioe) {
			System.out.println("-E-:"+ ioe.getMessage());
		} 
	}
	
	public static void main(String[] args) {
		
		RuntimeComplexity runtimeComplexity = new RuntimeComplexity();
		
		runtimeComplexity.showExample1();
		runtimeComplexity.pause();
		
		runtimeComplexity.showExample2();
		runtimeComplexity.pause();
		
		runtimeComplexity.showExample3();
		runtimeComplexity.pause();
		
		runtimeComplexity.showExample4();
		runtimeComplexity.pause();
		runtimeComplexity.repeatExample4();
		runtimeComplexity.pause();
		
		runtimeComplexity.showExample5();
		runtimeComplexity.pause();
		runtimeComplexity.repeatExample5();
		
		runtimeComplexity.close_stream();

	}

}
