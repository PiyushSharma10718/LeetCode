import java.util.Stack;

public class lc_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            // Push opening brackets onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // Process closing brackets
            else {
                if (stack.isEmpty()) return false; // No matching opening bracket
                char top = stack.pop();
                
                // Check if the closing bracket matches the top of the stack
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        // If the stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        lc_20 obj = new lc_20();
        System.out.println(obj.isValid("()"));       // true
        System.out.println(obj.isValid("()[]{}"));   // true
        System.out.println(obj.isValid("(]"));       // false
        System.out.println(obj.isValid("([])"));     // true
    }
}
