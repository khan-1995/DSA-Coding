public class Solution {

    public static int  firstOccurence(int arr[], int n, int x) {
        int start = 0;
        int end = n-1;
        int first = -1;
        while(start <= end){
            int mid = (start+end)/2;

            if(arr[mid]==x){
                first = mid;
                end = mid-1;
            }else if(arr[mid] < x){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return first;
    }

    public static int lastOccurence(int arr[], int n, int x) {
        int start = 0;
        int end = n-1;
        int last = -1;
        while(start <= end){
            int mid = (start+end)/2;

            if(arr[mid]==x){
                last = mid;
                start = mid+1;
            }else if(arr[mid] < x){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return last;
    }

    public static int count(int arr[], int n, int x) {
        //Your code goes here
        int first = firstOccurence(arr,n,x);
        
        if(first==-1){
            return 0;
        }

        int last = lastOccurence(arr,n,x);

        return (last-first)+1;
    }
}