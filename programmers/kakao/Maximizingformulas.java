import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 조합 비트연산자 getBit로도 풀어 볼것 => 비트연산자 getBit는 최대한 다양하게 선택하는 것이다. 따라서 getBit로 (X)
 * 정규식 공부좀...
 */
public class Maximizingformulas {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("100-200*300-500+20"));
        System.out.println(new Solution().solution("50*6-3*2"));
    }

    static class Solution {
        static Long max;
        static Queue<Long> operandQ; // 피연산자
        static Queue<Character> operationQ; // 연산자
        static String[] str;
        public long solution(String expression) {
            max = Long.MIN_VALUE;
            str = expression.split("\\+|-|\\*");
            Set<Character> set = new HashSet<>();
            for (char c : expression.toCharArray()) {
                if (c == '+' || c == '-' || c == '*') {
                    set.add(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            set.forEach(c -> sb.append(c));
            boolean[] check = new boolean[set.size()];
            int[] arr = new int[set.size()];
            dfs(0, arr, expression, sb.toString(), check);
            return (max);
        }

        public void dfs(int depth, int[] arr, String expression, String operation, boolean[] check) {
            if (depth == operation.length()) {
                operandQ  = new LinkedList<>();
                operationQ  = new LinkedList<>();
                for (String s : str)
                    operandQ.offer(Long.parseLong(s));
                for (char c : expression.toCharArray()) {
                    if (c == '+' || c == '-' || c == '*') {
                        operationQ.offer(c);
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (int i : arr)
                    sb.append(operation.charAt(i));
                max = Math.max(max ,calculate(sb.toString()));
                return;
            }
            for (int i = 0; i < operation.length(); i++) {
                if (check[i])
                    continue;
                check[i] = true;
                arr[depth] = i;
                dfs(depth + 1, arr, expression, operation, check);
                check[i] = false;
            }
        }

        public Long calculate(String operation) {
            Long answer = 0L;
            for (char c : operation.toCharArray()) {
                Queue<Long> tempOperandQ = new LinkedList<>();
                Queue<Character> tempOperationQ = new LinkedList<>();
                while (!operationQ.isEmpty()) {
                    if (!operationQ.contains(c))
                        break;
                    if (operationQ.peek() == c) {
                        Long first = operandQ.poll();
                        if (c == '+')
                        {
                            answer = first + operandQ.poll();
                            operationQ.poll();
                        }
                        else if (c == '-')
                        {
                            answer = first - operandQ.poll();
                            operationQ.poll();
                        }
                        else if (c == '*')
                        {
                            answer = first * operandQ.poll();
                            operationQ.poll();
                        }
                        tempOperandQ.offer(answer);
                        while (!operandQ.isEmpty())
                            tempOperandQ.offer(operandQ.poll());
                        while (!operationQ.isEmpty())
                            tempOperationQ.offer(operationQ.poll());
                        operandQ = tempOperandQ;
                        operationQ = tempOperationQ;
                        tempOperandQ = new LinkedList<>();
                        tempOperationQ = new LinkedList<>();
                    }
                    else {
                        tempOperandQ.offer(operandQ.poll());
                        tempOperationQ.offer(operationQ.poll());
                    }
                }
            }
            return (Math.abs(answer));
        }
    }
}

