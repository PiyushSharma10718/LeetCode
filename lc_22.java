import java.util.ArrayList;
import java.util.List;

class lc_22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base case: if the current string is a valid combination
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        
        // Add an opening parenthesis if possible
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        
        // Add a closing parenthesis if it won't lead to invalid sequence
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        lc_22 gp = new lc_22();
        System.out.println(gp.generateParenthesis(3)); // Output: ["((()))","(()())","(())()","()(())","()()()"]
    }
}
