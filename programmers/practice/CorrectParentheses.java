import java.util.Stack;

public class CorrectParentheses {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("()()"));
        System.out.println(new Solution().solution("(())()"));
        System.out.println(new Solution().solution(")()("));
        System.out.println(new Solution().solution("(()("));
    }

    static class Solution {
        boolean solution(String s) {
            Stack<Character> stack = new Stack<>();
            if (s.charAt(0) == ')')
                return (false);
            if (s.charAt(s.length() - 1) == '(')
                return (false);
            stack.push('(');
            for (int i = 1; i < s.length(); i++)
            {
                if (!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == ')')
                    stack.pop();
                else
                    stack.push(s.charAt(i));
            }
            if (!stack.isEmpty())
                return(false);
            return (true);
        }
    }
}

