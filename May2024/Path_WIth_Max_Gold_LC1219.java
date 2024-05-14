class Solution {

    private int res = 0;

    public int getMaxPathWithGold(int row,int col,int[][] grid,Set<String> visited){

        if((Math.min(row,col)<0) || (row==grid.length || col==grid[0].length) || visited.contains(row+""+col) || grid[row][col]==0){
            return 0;
        }

        visited.add(row+""+col);
        
        res = grid[row][col];

        int[][] neighbours = {{row+1,col},{row-1,col},{row,col+1},{row,col-1}};

        for(int[] rc : neighbours){
            res =  Math.max(res,grid[row][col] + getMaxPathWithGold(rc[0],rc[1],grid,visited));
        }

        visited.remove(row+""+col);

        return res;
    }

    public int getMaximumGold(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                res  = Math.max(res,getMaxPathWithGold(r,c,grid,new HashSet<>()));
            }
        }

        return res;
    }
}
