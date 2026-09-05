class SmallestStableIndexII {
    public int firstStableIndex(int[] nums,int k) {
        int n=nums.length;
        int[] r=new int[n];
        r[n-1]=nums[n-1];

        for(int i=n-2;i>=0;i--){
            r[i]=Math.min(nums[i],r[i+1]);
        }

        int m=nums[0];

        for(int i=0;i<n;i++){
            m=Math.max(m,nums[i]);
            if(m-r[i]<=k)return i;
        }

        return -1;
    }
    public static void main(String[] args) {
        SmallestStableIndexII obj = new SmallestStableIndexII();
        int[] nums = {1, 3, 2, 4, 5};
        int k = 2;
        int result = obj.firstStableIndex(nums, k);
        System.out.println(result);
    }
}