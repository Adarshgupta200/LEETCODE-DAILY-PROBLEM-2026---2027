class MinimumSwapstoStopbyDigitSum {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] a = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int temp = nums[i];
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            a[i][0] = sum;
            a[i][1] = nums[i];
            a[i][2] = i;
        }
        
        java.util.Arrays.sort(a, (x, y) -> {
            if (x[0] != y[0]) return Integer.compare(x[0], y[0]);
            if (x[1] != y[1]) return Integer.compare(x[1], y[1]);
            return Integer.compare(x[2], y[2]);
        });
        
        boolean[] b = new boolean[n];
        int c = 0;
        int[] d = new int[n];
        
        for (int i = 0; i < n; i++) {
            d[a[i][2]] = i;
        }
        
        for (int i = 0; i < n; i++) {
            if (!b[i]) {
                int j = i;
                while (!b[j]) {
                    b[j] = true;
                    j = d[j];
                    c++;
                }
                c--;
            }
        }
        
        return c;
    }
    public static void main(String[] args) {
        MinimumSwapstoStopbyDigitSum obj = new MinimumSwapstoStopbyDigitSum();
        int[] nums = { 21, 12, 3, 30 };
        int result = obj.minSwaps(nums);
        
        // Print the result
        System.out.println(result); // Output: 2
    }
}