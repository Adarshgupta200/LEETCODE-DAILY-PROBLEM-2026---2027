import java.util.*;
class MinimumMovestoEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int mid = nums.length / 2;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            ans += Math.abs(nums[i] - nums[mid]);
        }

        return ans;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        MinimumMovestoEqualArrayElementsII obj = new MinimumMovestoEqualArrayElementsII();
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(obj.minMoves2(nums));
    }
}