class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int n = bloomDay.length;

        if((long) n < (long) (m*k)){
            return -1;
        }

        for(int i=0;i<bloomDay.length;i++){
            high = Math.max(high,bloomDay[i]);
            low = Math.min(low,bloomDay[i]);
        }
        int max = high;
        System.out.println(low);
        System.out.println(high);


        while(low<=high){
            int mid = ( low + high )/2;
            int consec_flwrs_count = 0;
            int total_bqts = 0;

            for(int i=0;i<n;i++){
                if(bloomDay[i]<=mid){
                    consec_flwrs_count+=1;
                }else{
                    total_bqts += (consec_flwrs_count/k);  
                    consec_flwrs_count = 0;
                }
            }
            total_bqts += (consec_flwrs_count/k);

            if(total_bqts>=m){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        if(low>max){
            return -1;
        }

        return low;
    }
}