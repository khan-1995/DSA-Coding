public class Solution {
    public static int NthRoot(int n, int m) {
        // Write your code here.
        
        int ans = -1;
        int low = 1;
        int high = m;


        while(low<=high){
            int mid = (low+high)/2;
            int val = mid;

        for(int i=m-1;i>0;i--){
            val = val*val;
        }

        if(val<=n){
            low = mid+1;
        }else{
            high = mid-1;
            ans = high;
        }

        }


        return ans;
    }
}
