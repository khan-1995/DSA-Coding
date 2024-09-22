//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

/* steps to approach 
 1.think the problem interms of index
 2. Do all stuffs on that index
 3. perform the asked operation like (MAX , MIN , No.od ways) on the above stuffs
 4. for performance oprimzation store them in an array ( Memoization ).
*/

class Solution{
    // private int min = Integer.MAX_VALUE;
    private int minimumEnergy(int[] height , int index,int[] dp){
        
        if(index==0){
            return 0;
        }
        
        if(dp[index]>=0){
            return dp[index];
        }
        
        int left = minimumEnergy(height,index-1,dp) + Math.abs(height[index]-height[index-1]);
        
        if(index>1){
            int right = minimumEnergy(height,index-2,dp) + Math.abs(height[index]-height[index-2]);
            dp[index] = Math.min(left,right);
            return dp[index];
        }
        dp[index] = left;
        
        return left;
        
    }
    public int minimumEnergy(int arr[],int N){
        //code here
        int[] dp = new int[N];
        Arrays.fill(dp,-1);
        
        
        return minimumEnergy(arr,N-1,dp);
    }
}
