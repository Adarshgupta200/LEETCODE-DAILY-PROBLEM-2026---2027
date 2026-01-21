import java.util.*;

class ConstructtheMinimumBitwiseArrayII {

    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] adarsh = new int[n];

        for (int i = 0; i < n; i++) {
            int ad = nums.get(i);

            if ((ad & 1) == 0) {
                adarsh[i] = -1;
                continue;
            }

            for (int an = 1; an < 32; an++) {
                if (((ad >> an) & 1) == 0) {
                    adarsh[i] = ad ^ (1 << (an - 1));
                    break;
                }
            }
        }
        return adarsh;
    }

    public static void main(String[] args) {
        ConstructtheMinimumBitwiseArrayII obj = new ConstructtheMinimumBitwiseArrayII();

        List<Integer> nums = new ArrayList<>();
        nums.add(13);
        nums.add(2);
        nums.add(17);

        int[] res = obj.minBitwiseArray(nums);

        System.out.println(Arrays.toString(res));
    }
}
