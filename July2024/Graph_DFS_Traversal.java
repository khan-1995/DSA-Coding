class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    
    private void dfs(ArrayList<ArrayList<Integer>> adj ,Set<Integer> visited,ArrayList<Integer> res,int node){
        
        visited.add(node);
        res.add(node);
        
        for(int v : adj.get(node)){
            if(!visited.contains(v)){
                dfs(adj,visited,res,v);
            }
        }
    }
    
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
       ArrayList<Integer> list = new ArrayList<>();
       dfs(adj,new HashSet<>(),list,0);
       
       return list;
    }
}
