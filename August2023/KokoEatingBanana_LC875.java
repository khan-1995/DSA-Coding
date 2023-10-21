class Solution {

    public int getMax(int[] arr){
        int max = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            max = Math.max(arr[i],max);
        }

        return max;
    }
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int max = getMax(piles);//Get Max
        int high = max;

        while(low<=high){
            int mid = (low+high)/2;

            int hour = 0;

            for (int i = 0; i < piles.length; i++) {
                hour += Math.ceil((double)(piles[i]) / (double)(mid));
            }

            if(hour<=h){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return low;
    }
}