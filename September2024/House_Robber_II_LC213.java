class Solution {
     private int solve(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int nextPrev = 0;

        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i>1){
                pick += nextPrev;
            }
            int not_pick = 0 + prev;
            nextPrev = prev;
            prev = Math.max(pick,not_pick);
        }

        System.out.println("Solve() >> "+prev);
        return prev;
    }
    public int rob(int[] nums) {

        if(nums.length==0){
            return 0;
        }

        if(nums.length==1){
            return nums[0];
        }

        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        // Since the arrangement is in circular remove first and last indices
        // Becuase in circular the last and first houses are neighbours
        for(int i=0;i<nums.length;i++){
            if(i!=0){
                list1.add(nums[i]);
            }

            if(i!=(nums.length-1)){
                list2.add(nums[i]);
            }
        }

        return Math.max(solve(list1.stream().mapToInt(el -> el).toArray()), solve(list2.stream().mapToInt(el -> el).toArray()));
    }
}
