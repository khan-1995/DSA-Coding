class Solution {
    private int helper(int index,int[] nums,int[] dp){

        if(index<0){
            return 0;
        }

        if(index==0){
            return nums[index];
        }

        if(dp[index]!=-1){
            return dp[index];
        }

        int pick = nums[index] + helper(index-2,nums,dp);// Pick the index
        int not_pick = 0 + helper(index-1,nums,dp);// Not pick the index
        // Use Memoization
        dp[index] = Math.max(not_pick,pick);
        
        return dp[index];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
      // Optimization using Tabulation   
      // dp[0] = nums[0];
      //   int pick = 0;
      //   int not_pick = 0;

      //   for(int i=1;i<n;i++){
      //       if(i>1){
      //           pick = nums[i] + dp[i-2];
      //       }
      //       not_pick = 0 + dp[i-1];
      //       dp[i] = Math.max(pick,not_pick);
      //   }

      /*
      Space optimization using variables and removed 1d dp array
      for(int i=1;i<n;i++){
            if(i>1){
                pick = nums[i] + nextPrev;
            }
            not_pick = 0 + prev;
            nextPrev = prev;
            prev = Math.max(pick,not_pick);
        }
      */
      
        return helper(n-1,nums,dp);
    }
}
