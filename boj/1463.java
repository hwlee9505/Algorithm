import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 다이나믹 프로그래밍 [Overlapping SubProblem, Optimal Substructure]
// 1. Top Down
//     1) 점화식을 구하기
//     2) 문제를 작은문제로 만들기
// D[n] = Min(D[n/3], D[n/2], D[n-1])

// 2. Bottom Up
//     1) 점화식을 구하기
//     2) 문제를 크기가 작은 문제부터 차례대로 푼다. 그리고 점점 크게 만들어 간다. => for문의 i++

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
        if (n == 1) {
            return 0;
        } else {
            if (memo[n] > 0) {
                return memo[n];
            }
            memo[n] = topDown(n - 1) + 1;

            if (n % 2 == 0) {
                int temp = topDown(n / 2) + 1;
                if (temp < memo[n]) {
                    memo[n] = temp;
                }
            }

            if (n % 3 == 0) {
                int temp = topDown(n / 3) + 1;
                if (temp < memo[n]) {
                    memo[n] = temp;
                }
            }
            return memo[n];
        }
    }

    // 2. DP - bottom up 방식
    public static int bottomUp(int n) {
        memo[1] = 0;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + 1;
            if (i % 2 == 0 && memo[i] > memo[i / 2] + 1) {
                memo[i] = memo[i / 2] + 1;
            }
            if (i % 3 == 0 && memo[i] > memo[i / 3] + 1) {
                memo[i] = memo[i / 3] + 1;
            }
        }
        return memo[n];
    }
}
