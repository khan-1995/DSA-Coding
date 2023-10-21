class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0;i<weights.length;i++){
            max = Math.max(max,weights[i]);
            sum+=weights[i];
        }

        // int total_w = 0;
        //Brute Force
        // for(int  j=max;j<=sum;j++){
        //    int total_d  = 1;
        //    total_w = 0;
        //     for(int i=0;i<weights.length;i++){
        //         if((total_w + weights[i]) > j){
        //             total_d+=1;
        //             total_w = weights[i];
        //         }else{
        //             total_w += weights[i];
        //         }
        //      }
        //     if(total_d <= days){
        //      return j;
        //     }
        //  }
        
        // return -1;

        //Optimal
        int low = max;
        int high = sum;

        while(low<=high){
            int mid = (low+high)/2;
            int total_w = 0;
            int total_d = 1;

            for(int i=0;i<weights.length;i++){
                if((total_w + weights[i]) > mid){
                    total_d+=1;
                    total_w = weights[i];
                }else{
                    total_w += weights[i];
                }
            }

            if(total_d <= days){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return low;
    }
}