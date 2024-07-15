//TC -> O(n*m) + 4 * ( n * m ) ~  O(n*m)
// SC -> O(n*m)
class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] visited = new int[rows][cols];
        int freshOranges=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j,0});
                    visited[i][j] = 2;
                }
                if(grid[i][j]==1){
                    freshOranges+=1;
                }
            }
        }

        if(freshOranges==0){
            return 0;
        }

        int minTime = -1;

        while(!queue.isEmpty()){
            /**Get the value*/
            /**Push valid nearest neighbours */
            /**incremnt previous  time+1 and update Max time */
            int[] rottenCell = queue.poll();
            int row = rottenCell[0];
            int col = rottenCell[1];
            int currTime = rottenCell[2];

            //Computed deltas for 4 directions
            //r+1 r-1 c+1 c-1
            int[] drow = new int[]{-1,0,1,0};
            int[] dcol = new int[]{0,1,0,-1};

            if(grid[row][col]==0){
                continue;
            }

            if(grid[row][col]==1){
                freshOranges--;
            }
            
            minTime = Math.max(currTime,minTime);
            
            for(int i=0;i<4;i++){
                int next_row =row + drow[i];
                int next_col = col + dcol[i];

                if(Math.min(next_row,next_col) >=0 && next_row<rows && next_col<cols){
                    if(visited[next_row][next_col] != 2){
                        queue.offer(new int[]{next_row,next_col,currTime+1});
                    }
                    visited[next_row][next_col] = 2;
                }
            }
            
        }

        return freshOranges>0 ? -1 : minTime;
    }
}
