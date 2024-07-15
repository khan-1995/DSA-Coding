class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        // Get the start point 
        // perfom BFS on four neightbours
        // mark them visited
        // return
        int rows = image.length;
        int cols = image[0].length;
        // int[][] visited = new int[rows][cols];
        int startColor = image[sr][sc];
        // Arrays.fill(visited,0);
        if(startColor==color){
            return image;
        }

        Queue<int[]> bfs_queue = new LinkedList<>();

        bfs_queue.offer(new int[]{sr,sc});
        // visited[sr][sc] = color;
        // image[sr][sc] = color;

        int[] drow = new int[]{-1,0,1,0};
        int[] dcol = new int[]{0,-1,0,1};

        while(!bfs_queue.isEmpty()){
            int[] cell = bfs_queue.poll();

            int row = cell[0];
            int col = cell[1];

            if(image[row][col]==startColor){
                image[row][col] = color;
            }

            for(int i=0;i<4;i++){
                int next_row  = row+drow[i];
                int next_col  = col+dcol[i];

                if(Math.min(next_row,next_col)>=0 && next_row<rows && next_col<cols){
                    if(image[next_row][next_col]==startColor){
                        image[next_row][next_col] = color;
                        bfs_queue.offer(new int[]{next_row,next_col});
                    }
                }
            }
        }

        return image;
    }
}
