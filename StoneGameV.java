import java.util.Arrays;

class StoneGameV {
    int[] s;
    int[][] dp;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        s = new int[n + 1];

        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + stoneValue[i];
        }

        dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, n - 1);
    }

    private int solve(int i, int j) {
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;

        for (int k = i; k < j; k++) {
            int l = s[k + 1] - s[i];
            int r = s[j + 1] - s[k + 1];

            if (l < r) {
                ans = Math.max(ans, l + solve(i, k));
            } else if (l > r) {
                ans = Math.max(ans, r + solve(k + 1, j));
            } else {
                ans = Math.max(ans,
                        l + Math.max(solve(i, k), solve(k + 1, j)));
            }
        }

        return dp[i][j] = ans;
    }

    public static void main(String[] args) {
        StoneGameV obj = new StoneGameV();

        int[] stoneValue = {6, 2, 3, 4, 5, 5};

        System.out.println(obj.stoneGameV(stoneValue));
    }
}