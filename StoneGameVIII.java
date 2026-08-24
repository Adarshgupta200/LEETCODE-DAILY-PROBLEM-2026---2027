class StoneGameVIII {
    public int stoneGameVIII(int[] stones) {
        int n=stones.length;
        int sum=0;
        for(int x:stones){
            sum += x;
        }
        int ans = sum;
        for(int i=n-1; i>1; i--){
            sum-=stones[i];
            ans=Math.max(ans, sum-ans);
        }
        return ans;
    }
 public static int void main(String[] args) {
        StoneGameVIII solution = new StoneGameVIII();
        int[] stones = {5, 3, 1, 4, 2};
        System.out.println(solution.stoneGameVIII(stones));
    }
}