class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (n > m) {
            return 0;
        }
    
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        
        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1; j--) {
                if (sChars[i - 1] == tChars[j - 1]) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        
        return dp[n];
    }
    public static void main(String[] args) {
        DistinctSubsequences obj = new DistinctSubsequences();
        String s = "rabbbit";
        String t = "rabbit";
        int result = obj.numDistinct(s, t);
        System.out.println(result);
    }
}