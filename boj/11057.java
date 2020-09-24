import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Dynamic Programming
//
// 1. 점화식 세우기
//
// D[N] = 수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 문제
//
// 수는 0으로 시작할 수 있다.
//-----------------------------------------------------
// D[i][j] = 길이가 i이고 마지막 숫자가 j인 오르막 수의 개수
// D[1][i] = 1
// D[i][j] += D[i-1][K] (0<=k<=j)
//-----------------------------------------------------

public class Main {

    public static long mod = 10007;
    public static long[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        memo = new long[n + 1][10];

        System.out.println(bottomUp(n));
    }

    public static long bottomUp(int n) {

        // Init
        // 길이가 1이고 마지막 숫자가 i인 오르막 수의 개수 = 1
        for (int i = 0; i < 10; i++) {
            memo[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    memo[i][j] += memo[i - 1][k];
                    memo[i][j] %= mod;
                }
            }
        }

        long answer =0;
        for(int i = 0; i <= 9; i ++){
            answer += memo[n][i];
        }
        answer %= mod;

        return answer;
    }
}
