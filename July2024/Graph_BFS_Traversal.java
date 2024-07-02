class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        
        
        while(!q.isEmpty()){
             int u = q.poll();
             
             for(int n : adj.get(u)){
                if(!visited.contains(n)){
                    q.offer(n);
                    visited.add(n);
                    list.add(n);
                }
             }
        }
        
        
        return list;
    }
}
