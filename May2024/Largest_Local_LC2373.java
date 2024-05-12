class Solution {

    
    public int[][] largestLocal(int[][] grid) {

        int ans_row = grid.length-2;
        int ans_col = grid[0].length-2;
        
        int[][] ans = new int[ans_row][ans_col];
        
        int max = 0;
        for(int i=0;i<ans_row;i++){
            for(int j=0;j<ans_row;j++){
                for(int r=i;r<i+3;r++){
                    for(int c=j;c<j+3;c++){
                        max = Math.max(max,grid[r][c]);    
                    }
                }
                ans[i][j] = max;
                max = 0;
            }
        }

        return ans;
    }
}
