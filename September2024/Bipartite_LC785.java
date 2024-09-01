//Bipartite Grph link
// https://miro.medium.com/v2/resize:fit:828/format:webp/0*eHf-wW8cPuxTA64A.png
class Solution {
    private int[] visited, color;

    public boolean dfs(int src, int clr, List<List<Integer>> graph) {
        visited[src] = 1;
        color[src] = clr;

        for (int neighbor : graph.get(src)) {
            if (visited[neighbor] == 0) {
                if (!dfs(neighbor, clr == 1 ? 2 : 1, graph)) {
                    return false;
                }
            } else if (color[src] == color[neighbor]) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new int[n];
        color = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            for (int j : graph[i]) {
                adjList.get(i).add(j);
            }
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, 1, adjList)) {
                    return false;
                }
            }
        }
        return true;
    }
}
