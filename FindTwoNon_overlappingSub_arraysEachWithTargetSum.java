import java.util.*;
class FindTwoNon_overlappingSub_arraysEachWithTargetSum {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,n+1);
        int sum=0;
        int left=0;
        int ans=n+1;
        int best=n+1;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            while(sum>target){
                sum-=arr[left++];
            }
            if(sum==target){
                int len=i-left+1;
                if(left>0 && dp[left-1]<=n){
                    ans=Math.min(ans,dp[left-1]+len);
                }
                best=Math.min(best,len);
            }
            dp[i]=best;
        }
        return ans==n+1?-1:ans;
    }
    public static void main(String[] args) {
        FindTwoNon_overlappingSub_arraysEachWithTargetSum obj = new FindTwoNon_overlappingSub_arraysEachWithTargetSum();
        int[] arr = {3, 2, 2, 4, 3};
        int target = 3;
        int result = obj.minSumOfLengths(arr, target);
        System.out.println(result); // Output the minimum sum of lengths of two non-overlapping sub-arrays
    }
}