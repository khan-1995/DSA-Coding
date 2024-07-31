class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] dist = new int[rows][cols];
        Queue<int[]> q = new LinkedList<>();

        int[][] visited = new int[rows][cols];

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(mat[r][c]==0){
                    visited[r][c] = -1;
                    q.offer(new int[]{r,c,0});
                }
            }
        }

        int[] row_del = new int[]{-1,0,1,0};
        int[] col_del = new int[]{0,-1,0,1};

        while(!q.isEmpty()){
            int[] pair = q.peek();

            int row = pair[0];
            int col = pair[1];
            int steps = pair[2];
            q.poll();

            for(int i=0;i<4;i++){
                int r = row + row_del[i];
                int c = col + col_del[i];

                if(Math.min(r,c)>=0 && (r<rows && c<cols) && visited[r][c]==0){
                    visited[r][c] = -1;
                    q.offer(new int[]{r,c,steps+1});
                    dist[r][c] = steps+1;
                }
            }
        }

        return dist;
    }
}
