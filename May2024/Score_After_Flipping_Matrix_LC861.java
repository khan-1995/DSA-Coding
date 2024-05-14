class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        /*Without manipulating i/p*/
        
        // Set score to summation of first colum
        int score = (1 << (n - 1)) * m;

        // Loop over all other columns
        for (int j = 1; j < n; j++) {
            int countSameBits = 0;
            for (int i = 0; i < m; i++) {
                // Count elements matching first in row
                if (grid[i][j] == grid[i][0]) {
                    countSameBits++;
                }
            }
            // Calculate score based on the number of same bits in a column
            countSameBits = Math.max(countSameBits, m - countSameBits);
            // Calculate the score contribution for the current column
            int columnScore = (1 << (n - j - 1)) * countSameBits;
            // Add contribution to score
            score += columnScore;
        }

        return score;

        /*With manipulating the i/p 
        
         - Look at left most bit 
         - There are only two rules that you need to know in this problem. If the first number in the row is 0, flip the row. If the count of 0 in the col is greater than the count of 1, flip the col.

         
            int row = grid.length;
            int col = grid[0].length;
    
            for(int r=0;r<row;r++){
                if(grid[r][0]==0){
                    for(int c=0;c<col;c++){
                        grid[r][c] =  grid[r][c]==0 ? 1 : 0;
                    }
                }
            }
    
             
            for(int c=0;c<col;c++){
                int one_count = 0;
                for(int r=0;r<row;r++){
                    one_count+=grid[r][c];
                }
    
                if(one_count < (row-one_count)){
                 for(int r=0;r<row;r++){
                    grid[r][c] =  grid[r][c]==0 ? 1 : 0;
                  }
                }
            }
    
            int res = 0;
            for(int r=0;r<row;r++){
                for(int c=0;c<col;c++){
                    // System.out.print(grid[r][c]+", ");
                    res+= grid[r][c] << (col-c-1);
                }
                // System.out.println("");
            }
            
            return res; 
        */
    }
}
