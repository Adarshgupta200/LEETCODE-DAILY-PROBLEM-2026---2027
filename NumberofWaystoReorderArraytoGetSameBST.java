import java.util.*;
class NumberofWaystoReorderArraytoGetSameBST {
    long[][] c;
    long m=1000000007;
    public int numOfWays(int[] nums) {
        int n=nums.length;
        c=new long[n][n];
        for(int i=0;i<n;i++){
            c[i][0]=1;
            for(int j=1;j<=i;j++){
                c[i][j]=(c[i-1][j-1]+c[i-1][j])%m;
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int x:nums)list.add(x);
        return (int)((dfs(list)-1+m)%m);
    }
    long dfs(List<Integer> list){
        if(list.size()<=2)return 1;
        List<Integer> l=new ArrayList<>();
        List<Integer> r=new ArrayList<>();
        int root=list.get(0);
        for(int i=1;i<list.size();i++){
            int v=list.get(i);
            if(v<root)l.add(v);
            else r.add(v);
        }
        long left=dfs(l);
        long right=dfs(r);
        int szL=l.size();
        int szR=r.size();
        long ways=c[szL+szR][szL];
        ways=(ways*left)%m;
        ways=(ways*right)%m;
        return ways;
    }
    public static void main(String[] args) {
        NumberofWaystoReorderArraytoGetSameBST obj = new NumberofWaystoReorderArraytoGetSameBST();
        int[] nums = { 2, 1, 3 };
        int result = obj.numOfWays(nums);
        
        // Print the result
        System.out.println(result); // Output: 1
    }
}