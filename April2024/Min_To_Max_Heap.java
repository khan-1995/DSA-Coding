public class Solution {

    public static void heapify(int index,int[] arr){

        int left = 2*index+1;
        int right = 2*index+2;
        int max = index;

        if(left<=arr.length-1 && arr[left] > arr[index]){
            max = left;
        }

        if(right<=arr.length-1 && arr[right] > arr[max]){
            max = right;
        }

        if(max!=index){
            int temp  = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;

            heapify(max,arr);
        }

    }
    public static int[] MinToMaxHeap(int n, int[] arr){
        // Write your code here
        for(int i=n/2;i>=0;i--){
           heapify(i,arr);
        }

        return arr;
    }
}
