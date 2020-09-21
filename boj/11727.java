import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        memo = new int[n + 1];
        System.out.println(topDown(n));
        memo = new int[n + 1];
        System.out.println(bottomUp(n));
    }

    // 1. DP - top down 방식
    public static int topDown(int n) {

        if (n == 0 || n == 1) {
            return n;
        } else if (n == 2) {
            return 3;
        } else {
            if (memo[n] > 0) {
                return memo[n];
            }
           memo[n] = topDown(n - 1) + 2 * topDown(n - 2);

            // ✨ 계산 과정 중간중간 %를 취해주지 않으면
            // 계산 도중에 int 자료형 범위의 최댓값을 벗어나서 오버플로우가 발생한다.
            return memo[n] % 10007;
        }
    }

    // 2. DP - bottom up 방식
    public static int bottomUp(int n) {

        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 3;

        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + 2 * memo[i - 2];
        }
        return memo[n] % 10007;
    }
} 
