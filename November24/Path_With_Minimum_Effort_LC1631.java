class Pair {
    int row;
    int col;
    int dist;
    public Pair(int r,int c,int d){
        this.row = r;
        this.col = c;
        this.dist = d;
    }
}
class Solution {
    
    public int minimumEffortPath(int[][] heights) {
        
        int r = heights.length;
        int c = heights[0].length;

        int[][] dist = new int[r][c];
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                dist[i][j] = (int) 1e9;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> a.dist - b.dist);
        pq.offer(new Pair(0,0,0));
        dist[0][0] = 0;

        int[] r_delta = new int[]{-1,0,1,0};
        int[] c_delta = new int[]{0,1,0,-1};

        while(!pq.isEmpty()){
            Pair p = pq.poll();

            int row = p.row;
            int col = p.col;
            int d = p.dist;

            //check if we reached dest
            if(row==r-1 && col==c-1){
                return d;
            }

            for(int i=0;i<4;i++){
                int nr = row + r_delta[i];
                int nc = col + c_delta[i];

                if(Math.min(nr,nc)>=0 && nc < c && nr < r){
                    int newEffort = Math.max(d , Math.abs(heights[row][col] - heights[nr][nc]));

                    if(newEffort < dist[nr][nc]){
                        dist[nr][nc] = newEffort;
                        pq.offer(new Pair(nr,nc,newEffort));
                    }
                }

            }

        }


        return 0;
    }
}
