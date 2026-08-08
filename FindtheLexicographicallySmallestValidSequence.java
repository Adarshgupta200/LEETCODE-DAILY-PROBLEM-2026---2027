class FindtheLexicographicallySmallestValidSequence {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] last = new int[m];
        java.util.Arrays.fill(last, -1);
        int i= n-1;
        int j= m-1;
        while(i>=0&&j>=0){
            if (word1.charAt(i)==word2.charAt(j)){
                last[j] =i;
                j--;
            }
            i--;
        }
        int[] ans = new int[m];
        boolean change=false;
        j =0;
        for(i =0; i<n&&j <m; i++){
            if(word1.charAt(i)==word2.charAt(j)) {
                ans[j]=i;
                j++;
            }else if(!change&&(j == m-1||i<last[j +1])){
                ans[j] =i;
                j++;
                change = true;
            }
        }
        if (j != m) {
            return new int[0];
        }

        return ans;
    }
    public static void main(String[] args) {
        FindtheLexicographicallySmallestValidSequence obj = new FindtheLexicographicallySmallestValidSequence();
        String word1 = "abacaba";
        String word2 = "bza";
        int[] res = obj.validSequence(word1, word2);
        System.out.println(java.util.Arrays.toString(res));
    }
}