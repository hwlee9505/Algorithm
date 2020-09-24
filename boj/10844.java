import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Dynamic Programming
//-----------------------------------------------
// Top Down
// 1. 점화식을 세운다.
// 2. 문제 -> 작은문제
//
// D[N] = 길이가 N인 계단 수가 총 몇개 있는지 구하는 문제
//-----------------------------------------------
// D[i][j] = 길이가 i이고 마지막 숫자가 j인 계단 수의 개수
// D[i][j] = D[i-1][j-1] + D[i-1][j+1]
//-----------------------------------------------
public class Main {

    public static long mod = 1000000000L;
    public static long[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // Bottom Up
        memo = new long[n + 1][10];
        System.out.println(bottomUp(n));
    }

    // Top Down - 어렵다..
    public static int topDown(int n) {
        return 0;
    }

    // Bottom Up
    public static long bottomUp(int n) {

        for (int i = 1; i <= 9; i++) {
            memo[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j - 1 >= 0) {
                    memo[i][j] += memo[i - 1][j - 1];
                }
                if (j + 1 <= 9) {
                    memo[i][j] += memo[i - 1][j + 1];
                }
                memo[i][j] %= mod;
            }
        }

        long answer = 0;
        for(int i = 0 ; i <= 9; i ++){
            answer += memo[n][i];
        }
        answer %= mod;

        return answer;
    }
}
