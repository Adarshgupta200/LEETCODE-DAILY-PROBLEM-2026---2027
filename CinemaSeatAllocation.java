import java.util.*;
class CinemaSeatAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int[] seat:reservedSeats){
            int row=seat[0];
            int s=seat[1];
            if(s>=2&&s<=9){
                map.put(row, map.getOrDefault(row,0)|(1<<(s-2)));
            }
        }
        int ans=(n-map.size())*2;
        for(int x:map.values()){
            boolean left = (x&15)==0;
            boolean middle = (x&60)==0;
            boolean right = (x&240)==0;
            if (left && right) {
                ans += 2;
            }else if(left||middle||right){
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        CinemaSeatAllocation csa = new CinemaSeatAllocation();
        int n = 3;
        int[][] reservedSeats = {{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
        int result = csa.maxNumberOfFamilies(n, reservedSeats);
        System.out.println("The maximum number of families that can be seated is: " + result);
    }
}