Class Solution {

  public int maxCrossingSum(int arr[], int l, int m,
                              int h)
    {
        // Include elements on left of mid.
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum = sum + arr[i];
            if (sum > left_sum)
                left_sum = sum;
        }
 
        // Include elements on right of mid
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m; i <= h; i++) {
            sum = sum + arr[i];
            if (sum > right_sum)
                right_sum = sum;
        }
 
        // Return sum of elements on left
        // and right of mid
        // returning only left_sum + right_sum will fail for
        // [-2, 1]
        return Math.max(left_sum + right_sum - arr[m],
                        Math.max(left_sum, right_sum));
    }

   public int findMaxSubarray(int[] nums,int i,int j){

       if( i> j){
           return Integer.MIN_VALUE;
       }

       if( i==j ){
           return nums[i];
       }

       int len = nums.length;
       int mid = (i+j) / 2;

       int lss = findMaxSubarray(nums,i,mid-1);
       int rss = findMaxSubarray(nums,mid+1,j);
       int css = maxCrossingSum(nums,i,mid,j);

       return Math.max(Math.max(lss,rss),css);
   }

    public int maxSubArray(int[] nums) {
        
        /**Using didvide and conquer algo O(nlogn) */
        return findMaxSubarray(nums,0,nums.length-1);

        /**Using kadanes algo O(n) */
        int max_sum = Integer.MIN_VALUE;
        int sum = 0;
        int start = -1;
        int end = -1;

        for(int i=0;i<nums.length;i++){
            if(sum > 0){
                sum+=nums[i];
                end = i;
            System.out.print(nums[i]+",");
            }else if(sum == 0){
                sum+=nums[i];
                start = i;
            }

            if(sum<0){
                sum = 0;
            }
            max_sum = Math.max(max_sum,sum);
        }


        return max_sum;
        
    }
}
