class MaximumSubarrayWithEqualProducts {
    public int maxLength(int[] nums) {
        int n=nums.length;
        int ans=2;
        for(int i=0;i<n;i++) {
            int p=1,g=0,l=1;
            for(int j=i;j<n;j++) {
                p*=nums[j];
                if(p>25200) break;
                g=(g==0)?nums[j]:gcd(g,nums[j]);
                l=(l/gcd(l,nums[j]))*nums[j];
                if(p==l*g) ans=Math.max(ans,j-i+1);
            }
        }
        return ans;
    }

    int gcd(int a,int b) {
        while(b!=0) {
            int t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
    public static void main(String[] args) {
        MaximumSubarrayWithEqualProducts obj = new MaximumSubarrayWithEqualProducts();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(obj.maxLength(nums)); // Output: 2
    }
}