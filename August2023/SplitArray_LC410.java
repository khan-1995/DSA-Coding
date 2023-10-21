class Solution {

    public boolean getSubArrays(int[] nums,int arr_sum,int k) {

        int sub_array_cnt = 1;
        int sum = 0;

        for(int i=0;i<nums.length;i++){
            if(sum + nums[i]<=arr_sum ){
                sum+=nums[i];
            }else{
                sub_array_cnt++;
                sum = nums[i];
            }
        }

        return sub_array_cnt>k;
    }

    public int splitArray(int[] nums, int k) {

        int min = nums[0];
        int max = 0;

        if(k>nums.length){
            return -1;
        }

        for(int n : nums){
            min = Math.max(n,min);
            max+=n;
        }
        
        //Brute force
        // for(int i=min;i<=max;i++){
        //     if(getSubArrays(nums,i,k)){
        //         return i;
        //     }
        // }

        //Optimal
        while(min<=max){
            int mid = (min+max)/2;

            if(getSubArrays(nums,mid,k)){
                min = mid+1;
            }else{
                max = mid-1;
            }
        
        }

        return min;
    }
}