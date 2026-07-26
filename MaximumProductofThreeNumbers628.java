class MaximumProductofThreeNumbers628 {
    public int maximumProduct(int[] nums){
        int max1 =Integer.MIN_VALUE;
        int max2 =Integer.MIN_VALUE;
        int max3 =Integer.MIN_VALUE;
        int min1 =Integer.MAX_VALUE;
        int min2 =Integer.MAX_VALUE;
        for(int x:nums){
            if(x>max1){
                max3 = max2;
                max2 = max1;
                max1 = x;
            }else if(x>max2){
                max3 = max2;
                max2 = x;
            }else if(x> max3){
                max3 = x;
            }
            if(x<min1){
                min2= min1;
                min1= x;
            }else if(x <min2){
                min2 = x;
            }
        }
        return Math.max(max1*max2*max3,max1*min1*min2);
    }
    public static void main(String[] args) {
        MaximumProductofThreeNumbers628 obj = new MaximumProductofThreeNumbers628();
        int[] nums = {1,2,3};
        int res = obj.maximumProduct(nums);
        System.out.println(res);
    }
}