import java.util.*;
class FindMissingElements3731 {
    public List<Integer> findMissingElements(int[] nums){
        int min = nums[0];
        int max = nums[0];
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums){
            min = Math.min(min,x);
            max = Math.max(max,x);
            set.add(x);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=min+1; i<max; i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        FindMissingElements3731 obj = new FindMissingElements3731();
        int[] nums = {4,2,7,5};
        List<Integer> res = obj.findMissingElements(nums);
        System.out.println(res);
    }
}