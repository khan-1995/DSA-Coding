class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // prepare adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        Queue<Integer> queue = new LinkedList<>();

        int[] inorder = new int[adj.size()];

        // prepare inorder
        for(int i=0;i<adj.size();i++){
            for(int it : adj.get(i)){
                inorder[it]++;
            }
        }

        for(int i=0;i<adj.size();i++){
            if(inorder[i]==0){
                queue.offer(i);
            }
        }

        List<Integer> topoSort = new ArrayList<>();

        while(!queue.isEmpty()){
            int v = queue.poll();
            topoSort.add(v);
            for(int n : adj.get(v)){
                inorder[n]--;
                if(inorder[n]==0){
                    queue.offer(n);
                }
            }
        }

        if(topoSort.size()==adj.size()){
            return true;
        }

        return false;

        //do topo sort
        // if cycle found return false else true
        
    }
}
