import java.util.*;
class StoneGameIII1406 {
    public int[] dp;
    public int[] arr;
    public int n;
    public String stoneGameIII(int[] stoneValue){
        arr = stoneValue;
        n = arr.length;
        dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int ans =solve(0);
        if(ans >0){
            return "Alice";
        }else if(ans < 0){
            return "Bob";
        }
        return"Tie";
    }
    public int solve(int i){
        if(i>= n){
            return 0;
        }
        if(dp[i]!= Integer.MIN_VALUE){
            return dp[i];
        }
        int sum=0;
        int best =Integer.MIN_VALUE;
        for(int j=i; j<Math.min(n, i+3); j++){
            sum +=arr[j];
            best =Math.max(best, sum-solve(j + 1));
        }
        return dp[i]=best;
    }
    public static void main(String[] args) {
        StoneGameIII1406 obj = new StoneGameIII1406();
        int[] stoneValue = {1,2,3,7};
        String res = obj.stoneGameIII(stoneValue);
        System.out.println(res);
    }
}