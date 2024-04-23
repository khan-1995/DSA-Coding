public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // If there is only one node, return it as the root of the minimum height tree
        if (n == 1) {
            return Collections.singletonList(0);
        }

        // Create an adjacency list to represent the graph
        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        // Populate the adjacency list based on the edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }

        // Find all leaf nodes (nodes with only one neighbor) as the starting point
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adjList[i].size() == 1) {
                leaves.add(i);
            }
        }

        // Keep track of the remaining nodes to process
        int remainingNodes = n;

        // Continue until there are only 1 or 2 nodes left
        while (remainingNodes > 2) {
            // Reduce the remaining nodes by the number of current leaf nodes
            remainingNodes -= leaves.size();

            // Create a new list to store the new leaf nodes for the next iteration
            List<Integer> newLeaves = new ArrayList<>();

            // Remove current leaf nodes and update their neighbors
            for (int leaf : leaves) {
                int neighbor = adjList[leaf].get(0);
                adjList[neighbor].remove(Integer.valueOf(leaf));

                // If the neighbor becomes a leaf node, add it to the new leaves list
                if (adjList[neighbor].size() == 1) {
                    newLeaves.add(neighbor);
                }
            }

            // Update the current leaf nodes for the next iteration
            leaves = newLeaves;
        }

        // At this point, the remaining nodes are the centers of the minimum height trees
        return leaves;
    }
}
