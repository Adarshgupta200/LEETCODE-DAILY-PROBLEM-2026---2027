class StoneGameII {
    int[][] dp;
    int[] s;
    public int stoneGameII(int[] a) {
        int n =a.length;
        dp = new int[n][n+1];
        s = new int[n+1];
        for(int i=n-1; i>=0; i--){
            s[i] = s[i+1]+a[i];
        }
        return solve(0, 1);
    }
    public int solve(int i, int m){
        if(i >=s.length - 1)
            return 0;
        if(dp[i][m] != 0)
            return dp[i][m];
        int ans = 0;
        for(int x=1; x<=2*m&&i+x<s.length; x++){
            ans = Math.max(ans, s[i]-solve(i+x, Math.max(m, x)));
        }
        return dp[i][m] = ans;
    }
    public static void main(String[] args) {
        StoneGameII obj = new StoneGameII();
        int[] piles = {2,7,9,4,4};
        int res = obj.stoneGameII(piles);
        System.out.println(res);
    }
}