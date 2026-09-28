class MaximumNestingDepthoftheParentheses {
    public int maxDepth(String s) {
        int currentDepth = 0;
        int maxDepth = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (c == ')') {
                currentDepth--;
            }
        }
        
        return maxDepth;
    }
    public static void main(String[] args) {
        MaximumNestingDepthoftheParentheses obj = new MaximumNestingDepthoftheParentheses();
        String s = "(1+(2*3)+((8)/4))+1";
        int result = obj.maxDepth(s);
        System.out.println(result); // Output: 3
    }
}