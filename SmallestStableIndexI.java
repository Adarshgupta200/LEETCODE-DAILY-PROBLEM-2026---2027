class SmallestStableIndexI {
    public int firstStableIndex(int[]nums, int k) {
        int n=nums.length;
        int a=nums[0]; 
        
        for(int i=0; i<n; i++) {
            if(nums[i]>a) {
                a=nums[i];
            }
            
            int b=nums[i];
            for(int j=i+1; j<n; j++) {
                if(nums[j]<b) {
                    b=nums[j];
                }
            }
            
            if(a-b<=k) {
                return i;
            }
        }
        
        return -1;
    }
    public static void main(String[] args) {
        SmallestStableIndexI obj = new SmallestStableIndexI();
        int[] nums = {1, 3, 2, 4, 5};
        int k = 2;
        int result = obj.firstStableIndex(nums, k);
        System.out.println(result);
    }
}