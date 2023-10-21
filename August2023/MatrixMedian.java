public final class Solution {

    public static int lowerBound(int[] arr, int x){

        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = ( low + high )/2;
            if(arr[mid]<=x){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return low;
    }

    public static int getSmallerElementsCount(int[][] matrix,int x,int m){
        int count = 0;

        for(int i=0;i<m;i++){
            count += lowerBound(matrix[i],x);
        }

        return count;
    }
    public static int findMedian(int matrix[][], int m, int n) {
        // Write your code here
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i=0;i<m;i++){
            low = Math.min(low,matrix[i][0]);
            high = Math.max(high,matrix[i][n-1]);
        }

        int medianPos = (n * m)/2;

        while(low <= high){
            int mid = (low+high)/2;
            int smallerEleCount = getSmallerElementsCount(matrix,mid,m);

            if(smallerEleCount <= medianPos){
                low = mid+1;
            }else{
                high = mid-1;
            }

        }

        return low;
    }
}