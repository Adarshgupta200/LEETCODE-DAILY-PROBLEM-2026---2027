class RemovingMinimumandMaximumFromArray {
    public int minimumDeletions(int[] nums) {
      int n = nums.length;
      int min = 0;
      int max = 0;
      for(int i=0; i<n; i++){
        if(nums[i]<nums[min]){
            min = i;
        }
        if(nums[i]>nums[max]){
            max = i;
        }
      } 
      int a = Math.max(min, max)+1;
      int b = n - Math.min(min, max);
      int c = Math.min(min, max)+1+n-Math.max(min, max); 
      return Math.min(a,Math.min(b,c));
    }
    public static void main(String[] args) {
        RemovingMinimumandMaximumFromArray obj = new RemovingMinimumandMaximumFromArray();
        int[] nums = {2,10,7,5,4,1,8,6};
        int result = obj.minimumDeletions(nums);
        System.out.println(result);
    }
}