import java.util.*;
class MinimumPositiveSumSubarray {
    public int minimumSumSubarray(List<Integer> nums,int l,int r) {
        int ans=Integer.MAX_VALUE;
        int n=nums.size();
        for(int i=0;i<n;i++) {
            int sum=0;
            for(int j=i;j<n;j++) {
                sum+=nums.get(j);
                int len=j-i+1;
                if(len>=l && len<=r && sum>0) {
                    ans=Math.min(ans,sum);
                }
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public static void main (String args[]){
        MinimumPositiveSumSubarray solution = new MinimumPositiveSumSubarray();
        List<Integer> nums = Arrays.asList(-1, 2, -3, 4, -5);
        int l = 2;
        int r = 4;
        int result = solution.minimumSumSubarray(nums, l, r);
        System.out.println(result); // Output: 1
    }
}