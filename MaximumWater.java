import java.io.*;
import java.util.*;

class Main{

    public static int maxArea(int[] a)
    {
    	int Area = 0;
    	
    	for(int i = 0; i < a.length; i++)
    	{
    		for(int j = i + 1; j < a.length; j++) 
    		{
    			Area = Math.max(Area, Math.min(a[i], a[j]) * (j - i));
    		}
    	}
    	return Area;
    }
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
    	int a[] = new int[n];
    	
    	for(int i=0;i<n;i++){
    	    a[i]=in.nextInt();
    	}
    
    	System.out.println(maxArea(a));
    	
    }
}
