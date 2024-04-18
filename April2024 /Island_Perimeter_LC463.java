/*Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.*/

class Solution {
    private int perimeter;
    public void traverse(int[][] grid,boolean[][] path,int row,int col){

        if((row>=grid.length || col>=grid[0].length) || (row<0 || col<0) || (grid[row][col]==0)){
            perimeter+=1;
            return;
        }

        if(path[row][col]){
            return;
        }

        path[row][col] = true;
        traverse(grid,path,row,col+1);
        traverse(grid,path,row+1,col);
        traverse(grid,path,row,col-1);
        traverse(grid,path,row-1,col);

        return;
    }

    public int islandPerimeter(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] path = new boolean[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    traverse(grid,path,i,j);
                }
            }
        }

        return perimeter;
    }
}
