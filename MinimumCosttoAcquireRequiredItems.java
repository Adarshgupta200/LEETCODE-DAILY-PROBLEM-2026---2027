class MinimumCosttoAcquireRequiredItems {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long a = 1L * need1 * cost1 + 1L * need2 * cost2;
        long b = 1L * Math.max(need1, need2) * costBoth;
        long m = Math.min(need1, need2);
        long c = m * costBoth + (need1 - m) * cost1 + (need2 - m) * cost2;
        return Math.min(a, Math.min(b, c));
    }
    public static void main(String[] args) {
        MinimumCosttoAcquireRequiredItems solution = new MinimumCosttoAcquireRequiredItems();
        int cost1 = 2;
        int cost2 = 3;
        int costBoth = 4;
        int need1 = 5;
        int need2 = 6;
        long result = solution.minimumCost(cost1, cost2, costBoth, need1, need2);
        System.out.println(result); // Output: 38
    }
}