class Solution {

    private void dfs(char[][] board,int[][] visited,int row,int col){

        int[] r_delta = new int[]{-1,0,1,0};
        int[] c_delta = new int[]{0,1,0,-1};

        int rows = board.length;
        int cols = board[0].length;

        visited[row][col]=1;

        for(int i=0;i<4;i++){
            int nr = row + r_delta[i];
            int nc = col + c_delta[i];

            if(Math.min(nr,nc)>=0 && nr<rows && nc<cols && visited[nr][nc]==0 && board[nr][nc]=='O'){
                dfs(board,visited,nr,nc);
            }
        }

        return;
    }

    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        int[][] visited = new int[rows][cols];

      //Visit boundary rows
        for(int c=0;c<cols;c++){
            if(visited[0][c]==0 && board[0][c]=='O'){
                dfs(board,visited,0,c);
            }
            if(visited[rows-1][c]==0 && board[rows-1][c]=='O'){
                dfs(board,visited,rows-1,c);
            }
        }

      //Visit boundary cols
        for(int r=0;r<rows;r++){
            if(visited[r][0]==0 && board[r][0]=='O'){
                dfs(board,visited,r,0);
            }
            if(visited[r][cols-1]==0 && board[r][cols-1]=='O'){
                dfs(board,visited,r,cols-1);
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='O' && visited[i][j]==0){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
