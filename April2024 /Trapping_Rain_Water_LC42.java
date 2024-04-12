class Solution {
    public int trap(int[] height) {

        int[] left_max = new int[height.length];
        // int right_max = new int[height.length];
        int max_area = 0;

        int left_max_num = 0;
        int right_max_num = 0;

        for(int i=0;i<height.length;i++){
            left_max_num  = Math.max(left_max_num,height[i]);
            left_max[i] = left_max_num;
        }

        for(int i=height.length-1;i>=0;i--){
            right_max_num  = Math.max(right_max_num,height[i]);
            max_area += Math.min(left_max[i],right_max_num)-height[i];
        }

        return max_area;
    }
  /*
  Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.*/
}
