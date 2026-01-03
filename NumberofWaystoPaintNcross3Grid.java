import java.util.Scanner;
public class NumberofWaystoPaintNcross3Grid {
    final static int mod = 1000000007;
    static Long dp[][];
    public static int ad(int n){
    dp = new Long[n+1][2];
    long ad = solve(n, 0);
    long da = solve(n, 1);
    return (int)((ad+da)%mod);
    }
    public static Long solve(int row, int type){
        if(row == 1){
            return 6L;
        }
        if(dp[row][type]!=null) return dp[row][type];
        long res;
        if(type == 0){
            res = (3*solve(row-1,0)+2*solve(row-1, 1))%mod;
        }else{
            res = (2*solve(row-1, 0)+2*solve(row-1, 1))%mod;
        }
        dp[row][type]= res;
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt();
        System.out.println(ad(t));
    }
}
