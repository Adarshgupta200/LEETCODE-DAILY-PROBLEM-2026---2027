class MaximumNumberofitemsFromSaleI {
    public int maximumSaleItems(int[][] items, int budget) {
        int[] dp = new int[budget + 1];
        int mn = Integer.MAX_VALUE;

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];
            mn = Math.min(mn, price);

            int cnt = 0;
            for (int[] other : items) {
                if (other[0] % factor == 0) {
                    cnt++;
                }
            }

            for (int j = budget; j >= price; j--) {
                dp[j] = Math.max(dp[j], dp[j - price] + cnt);
            }
        }

        int ans = 0;
        for (int i = 0; i <= budget; i++) {
            ans = Math.max(ans, dp[i] + (budget - i) / mn);
        }

        return ans;
    }

    public static void main(String[] args) {
        MaximumNumberofitemsFromSaleI obj = new MaximumNumberofitemsFromSaleI();

        int[][] items1 = {{2, 5}, {4, 3}, {6, 4}};
        int budget1 = 8;
        System.out.println(obj.maximumSaleItems(items1, budget1));

        int[][] items2 = {{1, 10}, {2, 2}, {3, 2}};
        int budget2 = 10;
        System.out.println(obj.maximumSaleItems(items2, budget2));
    }
}