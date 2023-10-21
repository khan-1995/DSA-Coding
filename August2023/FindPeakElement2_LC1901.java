class Solution {

    public int findPeakElement(int[][] mat,int n,int m,int col){
        
        int row_index = 0;
        int peak = -1;
        int index = -1;
        for(int i=0;i<n;i++){
            if(mat[i][col] > peak){
                peak = mat[i][col];
                index = i;
            }
        }
        // System.out.print("Peak "+index);
        return index;
    }

    public int[] findPeakGrid(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int row = n;
        int col = m;
        int low = 0 ,high = m-1;

        while(low<=high){
            int mid = (low+high)/2;
            int peak_row_index = findPeakElement(mat,n,m,mid);
            int left = mid-1 >= 0 ? mat[peak_row_index][mid - 1]  : -1;
            int right = mid+1 < n ? mat[peak_row_index][mid + 1] : -1;

            if(mat[peak_row_index][mid] > left && mat[peak_row_index][mid] > right){
                return new int[]{peak_row_index,mid};
            }else if( left > mat[peak_row_index][mid] ){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return new int[]{-1,-1};
    }
}