class SubarraysDistinctElementSumofSquaresII {
    static final long m = 1000000007;
    long[] sum, sqSum, lz;

    public int sumCounts(int[] a) {
        int n = a.length;
        sum = new long[4 * n];
        sqSum = new long[4 * n];
        lz = new long[4 * n];
        Map<Integer, Integer> mp = new HashMap<>();
        long ans = 0;
        
        for (int r = 0; r < n; r++) {
            int l = mp.getOrDefault(a[r], -1) + 1;
            mp.put(a[r], r);
            update(1, 0, n - 1, l, r, 1);
            ans = (ans + sqSum[1]) % m;
        }
        return (int) ans;
    }

    void push(int id, int nl, int nr) {
        if (lz[id] != 0) {
            int mid = (nl + nr) / 2;
            apply(2 * id, nl, mid, lz[id]);
            apply(2 * id + 1, mid + 1, nr, lz[id]);
            lz[id] = 0;
        }
    }

    void apply(int id, int nl, int nr, long val) {
        long len = (nr - nl + 1);
        long curSum = sum[id];
        sqSum[id] = (sqSum[id] + 2 * val * curSum + val * val % m * len) % m;
        sum[id] = (sum[id] + val * len) % m;
        lz[id] = (lz[id] + val) % m;
    }

    void update(int id, int nl, int nr, int ql, int qr, long val) {
        if (ql <= nl && nr <= qr) {
            apply(id, nl, nr, val);
            return;
        }
        push(id, nl, nr);
        int mid = (nl + nr) / 2;
        if (ql <= mid) update(2 * id, nl, mid, ql, qr, val);
        if (qr > mid) update(2 * id + 1, mid + 1, nr, ql, qr, val);
        sum[id] = (sum[2 * id] + sum[2 * id + 1]) % m;
        sqSum[id] = (sqSum[2 * id] + sqSum[2 * id + 1]) % m;
    }
    public static void main(String[] args) {
        SubarraysDistinctElementSumofSquaresII obj = new SubarraysDistinctElementSumofSquaresII();
        int[] a = {1, 2, 1};
        int result = obj.sumCounts(a);
        
        // Print the result
        System.out.println(result); // Output: 14
    }
}