import java.util.*;
class FindTargetIndicesAfterSortingArray {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                ans.add(i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        FindTargetIndicesAfterSortingArray obj = new FindTargetIndicesAfterSortingArray();
        int[] nums = { 1, 2, 5, 2, 3 };
        int target = 2;
        List<Integer> result = obj.targetIndices(nums, target);
        
        // Print the result
        System.out.println(result); // Output: [1, 2]
    }
}