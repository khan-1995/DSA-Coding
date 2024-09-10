class Solution {
    ArrayList<Integer> result = new ArrayList<>();
    private int[] orderCourses(List<ArrayList<Integer>> edges,int n){
        int v = edges.size();

        int[] visted = new int[n];
        int[] visitedPath = new int[n];

        for(int i=0;i<n;i++){
            if(isCycle(edges,i,visted,visitedPath)){
                return new int[]{};
            }
        }
        // System.out.print(" Size "+result.size());

        return result.stream().mapToInt(el -> el).toArray();
    }

    private boolean isCycle(List<ArrayList<Integer>> edges , int v , int[] visited, int[] visitedPath){
        if(visited[v]!=1){
            visited[v] = 1;
            visitedPath[v] = 1;
            for(int el : edges.get(v)){
                if(visited[el]==0 && isCycle(edges,el,visited,visitedPath)){
                    return true;
                }else if(visitedPath[el]==1){
                    return true;
                }
            }
            result.add(v);
        }
        visitedPath[v] = 0;
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
           // Create adj list
           // perform dfs and check if cycle exists
           // add the nodes to results array

           List<ArrayList<Integer>> edges = new ArrayList<>();
           int vertices = numCourses;

           for(int i=0;i<vertices;i++){
                edges.add(new ArrayList<>());
           }

           for(int i=0;i<prerequisites.length;i++){
                int[] sub = prerequisites[i];
                edges.get(sub[0]).add(sub[1]);
           }

           return orderCourses(edges,numCourses);
    }
}
