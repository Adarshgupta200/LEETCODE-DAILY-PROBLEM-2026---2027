class MinimumMovestoEqualArrayElements {
    public int minMoves(int[] nums){
        int a=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]<a){
                a=nums[i];
            }
        }
        int b=0;
        for(int i=0;i<nums.length;i++){
            int c=nums[i];
            b+=c-a;
        }
        return b;
    }
    public static void main(String[] args) {
        MinimumMovestoEqualArrayElements obj = new MinimumMovestoEqualArrayElements();
        int[] nums = {1,2,3}; 
        System.out.println(obj.minMoves(nums));
    }
}