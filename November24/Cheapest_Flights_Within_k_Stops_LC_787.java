class Pair{
    int first;
    int second;

    public Pair(int f,int s){
        this.first = f;
        this.second = s;
    }
}

class Tuple{
    int first;
    int second;
    int third;

    public Tuple(int f,int s,int t){
        this.first = f;
        this.second = s;
        this.third = t;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist,(int)1e9);

        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(0,src,0));

        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            int stops = tuple.first;
            int node = tuple.second;
            int cost = tuple.third;

            if(stops>k){
                continue;
            }else{
                for(Pair p : adj.get(node)){
                    int adjNode = p.first;
                    int adjCost = p.second;

                    if(cost+adjCost < dist[adjNode]){
                        dist[adjNode] = cost + adjCost;
                        queue.offer(new Tuple(stops+1,adjNode,dist[adjNode]));
                    }
                }
            }
        }

        return dist[dst]==(int)1e9 ? -1 : dist[dst];
    }
}
