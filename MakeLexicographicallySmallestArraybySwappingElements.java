import java.util.Arrays;
class MakeLexicographicallySmallestArraybySwappingElements {
    public int[] lexicographicallySmallestArray(int[] nums,int limit) {
        int n=nums.length;
        int[][] pairs=new int[n][2];
        for(int i=0;i<n;i++){
            pairs[i][0]=nums[i];
            pairs[i][1]=i;
        }
        Arrays.sort(pairs,(a,b)->Integer.compare(a[0],b[0]));
        int[] result=new int[n];
        int i=0;
        while(i<n){
            int j=i+1;
            while(j<n&&pairs[j][0]-pairs[j-1][0]<=limit){
                j++;
            }
            int size=j-i;
            int[] indices=new int[size];
            for(int k=0;k<size;k++){
                indices[k]=pairs[i+k][1];
            }
            Arrays.sort(indices);
            for(int k=0;k<size;k++){
                int index=indices[k];
                int value=pairs[i+k][0];
                result[index]=value;
            }
            i=j;
        }
        return result;
    }
    public static void main(String[] args) {
        MakeLexicographicallySmallestArraybySwappingElements obj = new MakeLexicographicallySmallestArraybySwappingElements();
        int[] nums = {1, 3, 5, 2, 4};
        int limit = 2;
        int[] result = obj.lexicographicallySmallestArray(nums, limit);
        System.out.println(Arrays.toString(result));    
    }
}