class StoneGame877 {
    Integer[][] dp;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new Integer[n][n];
        return solve(0, n - 1, piles)>0;
    }
    public int solve(int i,int j, int[] piles){
        if(i==j)
            return piles[i];
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int left =piles[i]- solve(i+1, j,piles);
        int right =piles[j]- solve(i, j-1,piles);
        return dp[i][j] = Math.max(left, right);
    }
    public static void main(String[] args) {
        StoneGame877 obj = new StoneGame877();
        int[] piles = {5,3,4,5};
        boolean res = obj.stoneGame(piles);
        System.out.println(res);
    }
}