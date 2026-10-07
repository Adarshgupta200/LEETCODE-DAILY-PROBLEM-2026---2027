import java.util.*;
class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String a) {
        int b = 0, c = 0;
        for (int i = 0; i < a.length(); i++) {
            char f = a.charAt(i);
            if (f == '(') {
                b++;
            } else if (f == ')') {
                if (b > 0) b--;
                else c++;
            }
        }
        Set<String> res = new HashSet<>();
        dfs(a, 0, b, c, 0, new StringBuilder(), res);
        return new ArrayList<>(res);
    }

    private void dfs(String a, int i, int b, int c, int d, StringBuilder e, Set<String> res) {
        if (b < 0 || c < 0 || d < 0) return;
        if (i == a.length()) {
            if (b == 0 && c == 0 && d == 0) {
                res.add(e.toString());
            }
            return;
        }

        char f = a.charAt(i);
        int g = e.length();

        if (f == '(') {
            dfs(a, i + 1, b - 1, c, d, e, res);
            e.append(f);
            dfs(a, i + 1, b, c, d + 1, e, res);
            e.setLength(g);
        } else if (f == ')') {
            dfs(a, i + 1, b, c - 1, d, e, res);
            e.append(f);
            dfs(a, i + 1, b, c, d - 1, e, res);
            e.setLength(g);
        } else {
            e.append(f);
            dfs(a, i + 1, b, c, d, e, res);
            e.setLength(g);
        }
    }
    public static void main(String[] args) {
        RemoveInvalidParentheses obj = new RemoveInvalidParentheses();
        String s = "()())()";
        List<String> result = obj.removeInvalidParentheses(s);
        
        // Print the result
        System.out.println(result); // Output: ["()()()", "(())()"]
    }
}