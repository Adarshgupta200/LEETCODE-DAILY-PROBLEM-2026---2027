import java.util.Arrays;

class  MinimumScorebyChangingTwoElements {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int case1 = nums[n - 1] - nums[2]; // Remove 2 smallest
        int case2 = nums[n - 3] - nums[0]; // Remove 2 largest
        int case3 = nums[n - 2] - nums[1]; // Remove 1 smallest & 1 largest

        return Math.min(case1, Math.min(case2, case3));
    }
    public static void main(String[] args) {
        MinimumScorebyChangingTwoElements ad = new MinimumScorebyChangingTwoElements();
        int arr [] = {5,7,9,1,2,4};
        System.out.println(arr);
    }
}