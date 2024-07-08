class Solution {
// TC -> O ( n ^ 2) SC -> O(n)
    public int findTheWinner(int n, int k) {
        
        List<Integer> circle = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        
        int startIndex = 0;

        
        while (circle.size() > 1) {
            
            int removalIndex = (startIndex + k - 1) % circle.size();

            
            circle.remove(removalIndex);

            startIndex = removalIndex;
        }

        return circle.getFirst();
    }
}

// TC -> O ( n ) SC -> O(1) [ Most optimal ]
    public int findTheWinner(int n, int k) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + k) % i;
        }
        // add 1 to convert back to 1 indexing
        return ans + 1;
    }
