mport java.util.* ;
import java.io.*; 
public class Solution {
    public static int ceilingInSortedArray(int n, int x, int[] arr) {
        // Write your code here.
        int floor = -1;
        int ceil = -1;

        // Arrays.sort(arr);
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=x){
                floor = Math.max(floor,arr[i]);
            }

            if(arr[i]>=x){
                if(ceil==-1)
                    ceil = arr[i];
                
                ceil = Math.min(ceil,arr[i]);
            }
        }

        System.out.print(floor+" ");
        

        return ceil;
    }
}
