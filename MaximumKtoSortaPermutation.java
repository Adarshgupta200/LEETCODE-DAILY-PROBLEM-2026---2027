class Solution {
    public int sortPermutation(int[] nums) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                ans &= nums[i];
            }
        }
        return Math.max(ans, 0);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {your_input_array_here}; // Replace with your input array
        int result = solution.sortPermutation(nums);
        System.out.println(result);
    }
}