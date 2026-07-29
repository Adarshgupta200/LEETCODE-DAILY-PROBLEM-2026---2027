class SmallestPalindromicRearrangementII3518 {

    static final int limit = 1000001;
    static int[][] c = new int[5001][5001];

    static {
        for (int i = 0; i <= 5000; i++) {
            c[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
                if (c[i][j] > limit) {
                    c[i][j] = limit;
                }
            }
        }
    }

    public String smallestPalindrome(String s, int k) {

        int[] cnt = new int[26];

        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        int[] arr = new int[26];
        String mid = "";

        for (int i = 0; i < 26; i++) {
            arr[i] = cnt[i] / 2;
            if ((cnt[i] & 1) == 1) {
                mid = String.valueOf((char) ('a' + i));
            }
        }

        if (count(arr) < k) {
            return "";
        }

        StringBuilder left = new StringBuilder();
        int n = s.length() / 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                if (arr[j] == 0) {
                    continue;
                }
                arr[j]--;
                long way = count(arr);
                if (way >= k) {
                    left.append((char) ('a' + j));
                    break;
                }
                k -= way;
                arr[j]++;
            }
        }

        StringBuilder ans = new StringBuilder();

        ans.append(left);
        ans.append(mid);
        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }

    long count(int[] arr) {

        long ans = 1;
        int total = 0;

        for (int x : arr) {

            if (x == 0) {
                continue;
            }

            total += x;
            ans *= c[total][x];

            if (ans >= limit) {
                return limit;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        SmallestPalindromicRearrangementII3518 obj = new SmallestPalindromicRearrangementII3518();
        String s = "egcfe";
        int k = 1;
        String res = obj.smallestPalindrome(s, k);
        System.out.println(res);
    }
}