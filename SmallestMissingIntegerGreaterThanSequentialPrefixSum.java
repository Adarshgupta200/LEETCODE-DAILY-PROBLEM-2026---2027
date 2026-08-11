import java.util.HashSet;
class SmallestMissingIntegerGreaterThanSequentialPrefixSum {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        int i = 1;
        while(i<nums.length&&nums[i]==nums[i-1]+1){
            sum += nums[i];
            i++;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        while(set.contains(sum)){
            sum++;
        }
        return sum;
    }
    public static void main(String[] args) {
        SmallestMissingIntegerGreaterThanSequentialPrefixSum obj = new SmallestMissingIntegerGreaterThanSequentialPrefixSum();
        int[] nums = {1,2,3,4,5};
        int res = obj.missingInteger(nums);
        System.out.println(res);
    }
}