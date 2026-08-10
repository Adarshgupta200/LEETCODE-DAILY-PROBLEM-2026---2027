class StoneGameIV {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        for(int i=1; i<=n; i++){
            for(int j=1; j*j<=i; j++){
                if(!dp[i-j*j]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        StoneGameIV obj = new StoneGameIV();
        int n = 7;
        boolean res = obj.winnerSquareGame(n);
        System.out.println(res);
    }
}