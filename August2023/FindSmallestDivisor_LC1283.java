class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        if(nums.length > threshold){
            return -1;
        }

        for(int i=0;i<nums.length;i++){
            // min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }

        int low = 1,high=max;

        while(low<=high){
            int mid = ( low + high )/2;
            int sum = 0;

            for(int i=0;i<nums.length;i++){
                double d= ((double) (nums[i]) / (double) (mid));
                sum += Math.ceil(d);
            }

            if(sum <= threshold){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return low;
    }
}