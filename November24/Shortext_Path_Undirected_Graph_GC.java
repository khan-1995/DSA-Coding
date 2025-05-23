//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        int[] dists = new int[n];
        
        Arrays.fill(dists,Integer.MAX_VALUE);
        
        //Construct an adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        dists[0] = 0;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
                for(int nn : adj.get(node)){
                    if(dists[node] + 1 < dists[nn]){
                        dists[nn] = dists[node]+1;
                        queue.add(nn);
                    }
                }
        }
        
        for(int i=0;i<n;i++){
            if(dists[i]==Integer.MAX_VALUE){
                dists[i] = -1;
            }
        }
        
        
        
        return dists;
    }
}
