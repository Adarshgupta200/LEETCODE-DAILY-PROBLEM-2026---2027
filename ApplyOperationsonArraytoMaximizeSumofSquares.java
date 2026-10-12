import java.util.*;
class ApplyOperationsonArraytoMaximizeSumofSquares {
    public int maxSum(List<Integer> nums, int k) {
        int mod = 1000000007;
        int[] bits = new int[31];
        for (int num : nums) {
            for (int i = 0; i < 31; i++) {
                if (((num >> i) & 1) == 1) {
                    bits[i]++;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < k; i++) {
            long val = 0;
            for (int j = 0; j < 31; j++) {
                if (bits[j] > i) {
                    val |= (1L << j);
                }
            }   
            sum = (sum + (val * val) % mod) % mod;
        }
        return (int) sum;
    }
    public static void main(String args[]){
        ApplyOperationsonArraytoMaximizeSumofSquares obj = new ApplyOperationsonArraytoMaximizeSumofSquares();
        List<Integer> nums = Arrays.asList(1, 2, 3);
        int k = 2;
        int result = obj.maxSum(nums, k);
        
        // Print the result
        System.out.println(result); // Output: 14
    }
}