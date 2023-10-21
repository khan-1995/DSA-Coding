import java.util.* ;
import java.io.*; 

public class Solution {

	public static int sqrtN(long N) {
		/*
		 * Write your code here
		 */
		 if(N==0){
			 return 0;
		 }

		 if(N<0){
			 return 1;
		 }

		 int low = 1;
		 int high = (int) N;


		 while(low<=high){
			 int mid = (int) (low+high)/2;
			 int val = mid*mid;

			 if(val <= N){
				 low = mid+1;
			 }else{
				 high = mid-1;
			 }

		 }

		 return high;

	}
}
