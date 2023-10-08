class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int n = nums.length;
        int end = n-1;
        
        while(start<=end){
        int mid = (start+end)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[start]<=nums[mid]){//Check if left part is sorted
                if(nums[start]<=target && target<=nums[mid]){
                    //If element exists in left part the eleiminate right part
                    end = mid-1;
                }else{
                    start = mid+1;//Eliminate left part
                }
            }else{
                if(nums[mid]<=target && target<=nums[end]){
                    //If element exists in left part the eleiminate right part
                    start = mid+1;
                }else{
                    end = mid-1;//Eliminate left part
                }
            }
        }

        return -1;
    }
}