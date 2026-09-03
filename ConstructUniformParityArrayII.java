class ConstructUniformParityArrayII {
    public boolean uniformArray(int[] nums1) {
        int min = nums1[0];
        boolean even = true;
        for(int x:nums1){
            min=Math.min(min, x);
            if(x%2!=0){
                even = false;
            }
        }
        return min%2!=0||even;
    }
    public static void main(String[] args) {
        ConstructUniformParityArrayII obj = new ConstructUniformParityArrayII();
        int[] nums1 = {2,10,7,5,4,1,8,6};
        boolean result = obj.uniformArray(nums1);
        System.out.println(result);
    }
}