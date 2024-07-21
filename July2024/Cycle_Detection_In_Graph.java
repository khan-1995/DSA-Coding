//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Queue<int[]> bfs_queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        int src = adj.get(0).isEmpty() ? 1:0;
        bfs_queue.offer(new int[]{src,-1});
        visited.add(src);
        //System.out.println(">>"+src);
        
        
        while(!bfs_queue.isEmpty()){
            int[] pair = bfs_queue.peek();
            // System.out.print(" "+pair.length);
            int child = pair[0];
            int parent = pair[1];
            bfs_queue.poll();
            
            for(int adjacent : adj.get(child)){
                if(!visited.contains(adjacent)){
                    visited.add(adjacent);
                    bfs_queue.offer(new int[]{adjacent,child});
                }else if(parent!=adjacent){
                    return true;
                }
            }
        }
        
        return false;
    }
}
