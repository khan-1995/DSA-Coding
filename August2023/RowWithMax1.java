import java.util.ArrayList;
public class Solution
{
    public static int findFirstOccurence(ArrayList<Integer> arr){

        int low = 0;
        int high = arr.size()-1;
        int index = -1;

        while(low<=high){
            int mid = (low+high)/2;

            if(arr.get(mid)==1){
                index = mid;
                high = mid-1;
            }else if(1 < arr.get(mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return high;
    }
    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m)
    {
        //	  Write your code here.
        int max_count = 0;
        int index = Integer.MAX_VALUE;

        //     for(int row=0;row<n;row++){
        //         int count=0;
        //         for(int col=0;col<m;col++){
        //             // System.out.print(matrix.get(row).get(col)+", ");
        //             if(matrix.get(row).get(col)==1){
        //                 count++;
        //            }
        //     }
        //         if(count>max_count){
        //             max_count = count;
        //             index=row;
        //         }
        // }

            for(int row=0;row<n;row++){
                int count = m - findFirstOccurence(matrix.get(row));
                if(count>max_count){
                    max_count = count;
                    index=row;
                }
            }

        return index;
    }
}