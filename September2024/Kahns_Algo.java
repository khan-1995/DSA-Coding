//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edges = Integer.parseInt(st[0]);
            int vertices = Integer.parseInt(st[1]);

            for (int i = 0; i < vertices; i++) adj.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edges; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
            }

            ArrayList<Integer> res = new Solution().topologicalSort(adj);

            if (check(adj, vertices, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> adj, int V,
                         ArrayList<Integer> res) {

        if (V != res.size()) return false;

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res.get(i)] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


class Solution {
    // Function to return list containing vertices in Topological order.
    
    private static ArrayList<Integer> topSort(ArrayList<ArrayList<Integer>> adj,int V){
        
        int[] inDegree = new int[V];
        int[] topo = new int[V];    
        for(int i=0;i<V;i++){
            for(int n : adj.get(i)){
                inDegree[n]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        
        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }
        
        int index = 0;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            topo[index++] = node;
            
            for(int n : adj.get(node)){
                inDegree[index]--;
                if(inDegree[index]==0){
                    queue.offer(index);
                }
            }
        }
        
        return new ArrayList<Integer>(Arrays.asList(topo));
    }
    
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        
        return topSort(adj,adj.size());
    }
}
