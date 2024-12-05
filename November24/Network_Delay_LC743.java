class Pair{
    int first;
    int time;

    public Pair(int f,int t){
        this.first = f;
        this.time = t;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer,ArrayList<Pair>> map = new HashMap<>();

        for(int i=0;i<times.length;i++){
            ArrayList<Pair> neighbours = map.getOrDefault(times[i][0],new ArrayList<>());
            neighbours.add(new Pair(times[i][1],times[i][2]));
            map.put(times[i][0],neighbours);
        }

        Set<Integer> visited = new HashSet<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> (a.time - b.time));

        pq.offer(new Pair(k,0));
        // visited.add(k);
        int total = 0;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.first;
            int t = p.time;
            
            if(visited.contains(node)){
                continue;
            }
            visited.add(node);
            total = Math.max(t,total);

            if(map.containsKey(node)){
                for(Pair pair : map.get(node)){
                    int adjNode = pair.first;
                    int tW = pair.time;
                    pq.offer(new Pair(adjNode,tW + t));
                }
            }
        }
        System.out.println(visited.size());

        return visited.size()==n ? total : -1;
    }
}
