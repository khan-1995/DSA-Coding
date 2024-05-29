class Solution {
    record Info(TreeNode node, int col, int row) {}
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Info> pq = new PriorityQueue<>((a, b) 
                                                     -> a.col != b.col? 
                                                        a.col - b.col : a.row != b.row? 
                                                        a.row - b.row : a.node.val - b.node.val);
        traverse(root, pq, 0, 0);
        while (!pq.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            Info cur = pq.poll();
            tmp.add(cur.node.val);
            int curCol = cur.col;
            while (!pq.isEmpty() && pq.peek().col == curCol) {
                tmp.add(pq.poll().node.val);
            }
            res.add(tmp);
        }
        return res;
    }
    private void traverse(TreeNode cur, PriorityQueue<Info> pq, int col, int row) {
        if (cur == null) return;
        pq.offer(new Info(cur, col, row));
        traverse(cur.left, pq, col - 1, row + 1);
        traverse(cur.right, pq, col + 1, row + 1);
    }
}
