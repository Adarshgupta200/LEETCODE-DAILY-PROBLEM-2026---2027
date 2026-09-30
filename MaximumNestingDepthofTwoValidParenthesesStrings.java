class MaximumNestingDepthofTwoValidParenthesesStrings {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int depth = 0;
        
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            
            if (c == '(') {
                depth++;
                ans[i] = depth % 2;
            } else {
                ans[i] = depth % 2;
                depth--;
            }
        }
        
        return ans;
    }
    public static void main(String[] args) {
        MaximumNestingDepthofTwoValidParenthesesStrings obj = new MaximumNestingDepthofTwoValidParenthesesStrings();
        String seq = "(()())";
        int[] result = obj.maxDepthAfterSplit(seq);
        
        // Print the result
        for (int i : result) {
            System.out.print(i + " ");
        }
        // Output: 0 1 1 1 1 0
    }
}