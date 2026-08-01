class PredicttheWinner {
    public static Integer dp[][];
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new Integer[n+1][n+1];
        return solve(nums, 0, n-1)>=0;
    }
    public static int solve(int arr[], int i, int j){
        if(i==j) return arr[i];
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int left = arr[i]-solve(arr, i+1, j);
        int right = arr[j]-solve(arr, i, j-1);
        return dp[i][j]= Math.max(left, right);
    }
    public static void main(String[] args) {
        PredicttheWinner obj = new PredicttheWinner();
        int[] nums = {1,5,2};
        boolean res = obj.predictTheWinner(nums);
        System.out.println(res);
    }
}