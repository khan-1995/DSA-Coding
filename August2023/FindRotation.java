public class Solution {
    public static int findKRotation(int []arr){
        // Write your code here.
        int low =0;
        int high = arr.length-1;
        int min = Integer.MAX_VALUE;
        int index = 0;

        while(low<=high){
            int mid = (low+high)/2;

            //If whole array is sorted
            if(arr[low]<=arr[high]){
                if(arr[low] < min){
                index = low;
                min = arr[low];
                }

                break;
            }

            //Left part is sorted
            if(arr[low]<=arr[mid]){
                if(arr[low] < min){
                index = low;
                min = arr[low];
                }
                low = mid+1;
            }else{//Right part is sorted
                if(arr[mid] < min){
                index = mid;
                min = arr[mid];
                }
                high = mid-1;
            }
        }

        return index;
        
    }
}