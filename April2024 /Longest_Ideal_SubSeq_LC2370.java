class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        Arrays.fill(dp,0);

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int curr = ch - 'a';
            int longest = 1;
            for(int prev=0;prev<26;prev++){
                if(Math.abs(curr-prev)<=k){
                    longest = Math.max(longest,1+dp[prev]);
                }
            }
            dp[curr] = Math.max(longest,dp[curr]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
