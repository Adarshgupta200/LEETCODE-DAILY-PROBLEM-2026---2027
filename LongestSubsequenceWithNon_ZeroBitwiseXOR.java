class LongestSubsequenceWithNon_ZeroBitwiseXOR {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int xor=0;
        boolean hasNonZero = false;
        for(int i=0; i<n; i++){
            xor^=nums[i];
            if(nums[i]!=0){
                hasNonZero = true;
            }
        }
        if(xor!=0){
            return n;
        }else if(hasNonZero){
           return n-1;
        }else{
           return 0;
        }
    }
    public static void main(String[] args) {
        LongestSubsequenceWithNon_ZeroBitwiseXOR l = new LongestSubsequenceWithNon_ZeroBitwiseXOR();
        int[] nums = {1, 2, 3, 0, 0};
        System.out.println(l.longestSubsequence(nums));
    }
}