class Solution {
    private int minimumCoinsRequired(int[] coins,int index,int amount){
         
        if(index==0){
            if((amount%coins[index])==0){
                return (amount/coins[index]);
            }else{
                return (int) 1e9;
            } 
        }

        int notPick = 0 + minimumCoinsRequired(coins,index-1,amount);

        int pick = (int) 1e9;

        if(coins[index] <= amount){
            pick = 1 + minimumCoinsRequired(coins,index,amount-coins[index]);
        }

        return Math.min(pick,notPick);
    }

    public int coinChange(int[] coins, int amount) {
        // 1 , 2 , 5
        // int ans = minimumCoinsRequired(coins,coins.length-1,amount);
        int[][] dp = new int[coins.length][amount+1];
        
       // Base case for bottom up
        for(int i=0;i<=amount;i++){
            if((i%coins[0])==0){
                dp[0][i] = (i/coins[0]);
            }else{
                dp[0][i] = (int) 1e9; 
            }
        }

        for(int i=1;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                int notPick = 0 + dp[i-1][j];

                int pick = (int)1e9;

                if(coins[i]<=j){
                    pick = 1 + dp[i][j-coins[i]];
                }

                dp[i][j] = Math.min(pick,notPick);
            }
        }


        return dp[coins.length-1][amount] >= (int) 1e9 ? -1 : dp[coins.length-1][amount];
    }
}
