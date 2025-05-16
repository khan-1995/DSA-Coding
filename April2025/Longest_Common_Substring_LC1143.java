class Solution {

    private int LCShelper(String s1, String s2, int index1, int index2, int[][] dp) {

        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        int match = 0;
        int notmatch = 0;
        if (s1.charAt(index1) == s2.charAt(index2)) {
            match = 1 + LCShelper(s1, s2, index1 - 1, index2 - 1, dp);
        } else {
            notmatch = 0
                    + Math.max(LCShelper(s1, s2, index1 - 1, index2, dp), LCShelper(s1, s2, index1, index2 - 1, dp));
        }

        dp[index1][index2] = Math.max(match, notmatch);

        return dp[index1][index2];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        if (text1.equals(text2)) {
            return text1.length();
        }

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // for(int[] arr : dp){
        //     Arrays.fill(arr,-1);
        // }

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {

                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = 0 + Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];

        //return LCShelper(text1,text2,text1.length()-1,text2.length()-1,dp);
    }
}
