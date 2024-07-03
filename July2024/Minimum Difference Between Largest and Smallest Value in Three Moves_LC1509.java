class Solution {
    public int minDifference(int[] nums) {

        if(nums.length<=3){
            return 0;
        }
        
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        

        for(int start=0;start<4;start++){
            int end = nums.length-4 + start;//for case of zero
            int diff = Math.abs(nums[end]-nums[start]);
            ans = Math.min(diff,ans);
        }

        return ans;
    }
}
