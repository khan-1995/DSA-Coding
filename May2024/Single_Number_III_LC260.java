class Solution {
    public int[] singleNumber(int[] nums) {
        int overall_xor = 0;
        for (int n : nums) {
            overall_xor ^= n;
        }

        int first_group_xor = 0;
        int second_group_xor = 0;

        int bit_pos_dif = 1;
        while ((overall_xor & bit_pos_dif) != 1) {
            bit_pos_dif<<1;
        }

        for (int num : nums) {
            if ((num & bit_pos_dif) == 1) {
                first_group_xor ^= num;
            } else {
                second_group_xor ^= num;
            }
        }

        return new int[] {first_group_xor, second_group_xor};
    }
}
