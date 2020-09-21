import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 다이나믹 프로그래밍 [Overlapping SubProblem, Optimal Substructure]
// 1. 점화식
// 2. 문제 -> 작은 문제

// D[n] = Min(D[n/3], D[n/2], D[n-1])

public class Main {

    public static int[] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        memo = new int[n + 1];

        System.out.println(go(n));
    }

    public static int go(int n) {

        if (n == 1) {
            return 0;
        } else {
            if (memo[n] > 0) {
                return memo[n];
            }

            memo[n] = go(n - 1) + 1;

            if (n % 2 == 0) {
                int temp = go(n / 2) + 1;
                if (temp < memo[n]) {
                    memo[n] = temp;
                }
            }

            if (n % 3 == 0) {
                int temp = go(n / 3) + 1;
                if (temp < memo[n]) {
                    memo[n] = temp;
                }
            }

            return memo[n];
        }
    }
}
