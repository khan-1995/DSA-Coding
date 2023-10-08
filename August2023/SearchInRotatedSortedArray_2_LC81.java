class Solution {
    public boolean search(int[] nums, int target) {

        int start =0;
        int end = nums.length-1;

        while(start<=end){
        int mid = (start+end)/2;
            if(nums[mid] == target){
                return true;
            }

            //Edge Case : eg [3,1,2,3,3,3,3]
            if(nums[start]==nums[mid] && nums[mid]==nums[end]){
                start = start+1;
                end = end-1;
                continue;
            } 
            
            if(nums[start]<=nums[mid]){//Check if left part is sorted
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

        return false;
    }
}