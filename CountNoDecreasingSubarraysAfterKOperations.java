import java.util.*;
class CountNoDecreasingSubarraysAfterKOperations {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n=nums.length;
        long ans=0,cost=0;
        Deque<long[]> dq=new ArrayDeque<>();
        int r=n-1;
        for(int l=n-1;l>=0;l--){
            long val=nums[l];
            long cnt=1;
            while(!dq.isEmpty()&&dq.peekFirst()[0]<=val){
                long[] front=dq.pollFirst();
                cost+=(val-front[0])*front[1];
                cnt+=front[1];
            }
            dq.addFirst(new long[]{val,cnt});
            while(cost>k){
                long[] back=dq.peekLast();
                cost-=(back[0]-nums[r]);
                back[1]--;
                if(back[1]==0) dq.pollLast();
                r--;
            }
            ans+=(r-l+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        CountNoDecreasingSubarraysAfterKOperations solution = new CountNoDecreasingSubarraysAfterKOperations();
        int[] nums = {1, 2, 3, 2, 1};
        int k = 3;
        long result = solution.countNonDecreasingSubarrays(nums, k);
        System.out.println(result); // Output: 9
    }
}