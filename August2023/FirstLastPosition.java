ass Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int first = -1;
        int last = -1;
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start+(end - start)/2;
            if (nums[mid] == target) {
                if(nums[mid]==target && first==-1){
                    System.out.print(" >> "+mid);
                    first = mid;
                }else if(nums[mid]==target){
                    last = mid;
                }
                start = mid+1;
            }
            else if (target < nums[mid]) {
                 end = mid - 1;
            } else {
                    start = mid + 1;
            }
}
        //     if(nums[i]<=target){
        //         if(nums[i]==target && first==-1){
        //             first = i;
        //         }else if(nums[i]==target){
        //             last = i;
        //         }
        //     }
        // }

        if(first>last){
            last = first;
        }

        return new int[]{first,last};
    }
}
