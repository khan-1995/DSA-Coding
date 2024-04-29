class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = 0;

        for(int n : nums){
            xor = n ^ xor;
        }


        return Integer.bitCount(xor ^ k);
    }
}
