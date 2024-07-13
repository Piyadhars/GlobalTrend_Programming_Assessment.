import java.io.*;
import java.util.*;

class Main{

    public static int findKthLargest(int[] nums, int k) {
        if(k>nums.length){
            return -1;
        }
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        return sortedNums[nums.length - k];
    }
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
    	int a[] = new int[n];
    	for(int i=0;i<n;i++){
    	    a[i]=in.nextInt();
    	} 
    	System.out.println(findKthLargest(a,k));
    	
    }
}
