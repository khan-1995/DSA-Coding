class Solution {
  static int mod=1000000007;

    static long topDown(int n) {
      if(n==0){
          return 0;
      }
      if(n==1){
          return 1;
      }
        long dp[]=new long[n+1];
        Arrays.fill(dp,-1);
     return memoization(n,dp);
    }

/* Top Down Up Approach */
static long memoization(int n,long dp[]){
     if(n==0){
          return 0;
      }
      if(n==1){
          return 1;
      }
      if(dp[n]!=-1){
          return dp[n];
      }
      long first=memoization(n-1,dp);
      long second=memoization(n-2,dp);
      return dp[n]=(first+second)%mod;
}

/* Bottom Up Approach */
    static long bottomUp(int n) {
       long dp[]=new long[n+1];
       dp[0]=0;
       dp[1]=1;
       for(int i=2;i<=n;i++){
           dp[i]=(dp[i-1]+dp[i-2])%mod;
       }
       return dp[n];
    }
}
