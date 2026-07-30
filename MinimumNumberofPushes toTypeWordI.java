class MinimumNumberofPushesToTypeWordI {
    public int minimumPushes(String word) {
        int n = word.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans += (i / 8) + 1;
        }

        return ans;
    }
    public static void main(String[] args) {
        MinimumNumberofPushesToTypeWordI obj = new MinimumNumberofPushesToTypeWordI();
        String word = "abcdefghijklmnopqrstuvwxyz";
        int res = obj.minimumPushes(word);
        System.out.println(res);
    }

}