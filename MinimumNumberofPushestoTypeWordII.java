class MinimumNumberofPushestoTypeWordII {
    public int minimumPushes(String word) {
        int[] count = new int[26];
        for (char ch : word.toCharArray()){
            count[ch - 'a']++;
        }
        Arrays.sort(count);
        int ans = 0;
        int press = 1;
        int used = 0;
        for (int i = 25; i >= 0; i--){
            if(count[i] == 0) {
                break;
            }
            ans += count[i] * press;
            used++;
            if(used == 8){
                used = 0;
                press++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        MinimumNumberofPushestoTypeWordII obj = new MinimumNumberofPushestoTypeWordII();
        String word = "abcdefghijklmnopqrstuvwxyz";
        int res = obj.minimumPushes(word);
        System.out.println(res);
    }
}