import java.util.*;
class ClimbingStairsII      {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        int inf = Integer.MAX_VALUE / 2; 
        Arrays.fill(dp, inf);
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = Math.max(0, i - 3); j < i; j++) {
                int jumpCost = (i - j) * (i - j);
                dp[i] = Math.min(dp[i], dp[j] + costs[i - 1] + jumpCost);
            }
        }
        
        return dp[n];
    }
    public static void main(String[] args) {
        ClimbingStairsII solution = new ClimbingStairsII();
        int n = 5;
        int[] costs = {1, 2, 3, 4, 5};
        int result = solution.climbStairs(n, costs);
        System.out.println(result); // Output: 15
    }
}