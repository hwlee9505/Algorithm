import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 1,2,3 더하기 문제와 비슷
//--------------------------------------------------------------------
// Dynamic Programming [Overlapping SubProblem, Optimal Substructure]
//--------------------------------------------------------------------
// D[N] = N을 제곱수들의 합으로 표현할 때에 그 항의 최소개수를 구하는 문제
// D[N] = min( D[N-(i^2)] + 1 ) (1<=i^2<=n)
//
// O(N*루트N)
//--------------------------------------------------------------------

public class Main {

    public static int[] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        memo = new int[n + 1];
        bottomUp(n);
    }

    public static void bottomUp(int n) {
        // D[N] = N을 제곱수들의 합으로 표현할 때에 그 항의 최소개수를 구하는 문제
        // D[N] = min( D[N-(i^2)] + 1 ) (1<=i^2<=n)
        for (int i = 1; i <= n; i++) {
            memo[i] = 100000;
            for (int j = 1; j * j <= i; j++) {
                if (memo[i] > memo[i - j * j] + 1) {
                    memo[i] = memo[i - j * j] + 1;
                }
            }
        }
        System.out.println(memo[n]);
    }
}
