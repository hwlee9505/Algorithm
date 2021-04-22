package navigation;

class Run {
    public static void main(String[] args) {
        System.out.println(new TargetNumber().getNumberOfCases(new int[]{1, 1, 1, 1, 1}, 3));
    }
}

public class TargetNumber {
    public int getNumberOfCases(int[] numbers, int target) {
        return (DFS(numbers, target, 0));
    }

    public int  DFS(int[] numbers, int target, int depth) {
        // 1. 정답인 경우
        // 2. 불가능한 경우
        if (depth == numbers.length) {
            int sum = 0;
            for (int num : numbers)
                sum += num;
            return (sum == target ? 1 : 0);
        }
        // 3. 다음경우 호출
        int result = 0;
        numbers[depth] *= 1;
        result += DFS(numbers, target, depth + 1);

        numbers[depth] *= -1;
        result += DFS(numbers, target, depth + 1);
        return (result);
    }

}