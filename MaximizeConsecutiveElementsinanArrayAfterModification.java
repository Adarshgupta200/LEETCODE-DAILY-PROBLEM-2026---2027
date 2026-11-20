import java.util.*;
public class MaximizeConsecutiveElementsinanArrayAfterModification {
    

    public int maxSelectedElements(int[] nums){
        Arrays.sort(nums);
        int[] dp=new int[nums[nums.length-1]+2];
        int ans=0;
        for(int x:nums){
            dp[x+1]=dp[x]+1;
            dp[x]=dp[x-1]+1;
            ans=Math.max(ans,Math.max(dp[x],dp[x+1]));
        }
        return ans;
    }
    public static void main(String[] args) {
        MaximizeConsecutiveElementsinanArrayAfterModification ad = new MaximizeConsecutiveElementsinanArrayAfterModification();
        int arr [] = {5,7,9,1,2,4};
        System.out.println(ad.maxSelectedElements(arr));
    }

}
