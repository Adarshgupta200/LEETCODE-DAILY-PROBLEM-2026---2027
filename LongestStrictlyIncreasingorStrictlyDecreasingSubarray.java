class LongestStrictlyIncreasingorStrictlyDecreasingSubarray {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 0) return 0;
        
        int inc = 1;
        int dec = 1;
        int maxLength = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                dec = 1;
            } else if (nums[i] < nums[i - 1]) {
                dec++;
                inc = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            
            maxLength = Math.max(maxLength, Math.max(inc, dec));
        }
        
        return maxLength;
    }
    public static void main(String[] args) {
        LongestStrictlyIncreasingorStrictlyDecreasingSubarray solution = new LongestStrictlyIncreasingorStrictlyDecreasingSubarray();
        int[] nums = {1, 2, 3, 2, 1, 0, -1};
        int result = solution.longestMonotonicSubarray(nums);
        System.out.println(result); // Output: 7
    }
}