Class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        //Populate Set
        for(int n : nums){
            set.add(n);
        }

        int longest = 1;

        Iterator<Integer> iter = set.iterator();

        while(iter.hasNext()){
            int num = iter.next();
            if(!set.contains(num-1)){//Avoid repeating same number again
                int count = 1;
                while(set.contains(num+1)){//Count the longest sequence
                    count+=1;
                    num = num+1;
                }
                longest = Math.max(longest,count);
            }
        }

        return longest;
    }
}
