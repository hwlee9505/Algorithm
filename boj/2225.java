import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1,2,3 더하기 문제와 비슷
//---------------------------------------------------------
// Dynamic Programming
//---------------------------------------------------------
// D[N] = 0부터 N 까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수
//---------------------------------------------------------
public class Main {

    public static long mod = 1000000000L;
    public static long[][] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
       int k = Integer.parseInt(st.nextToken());

        // 1. O(K * N^2)
        memo = new long[k + 1][n + 1];
        bottomUp(k, n);

        // 2. O(K * N)
        memo = new long[k + 1][n + 1];
        bottomUp2(k, n);
    }

    public static void bottomUp(int k, int n) {

        memo[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                for (int l = 0; l <= j; l++) {
                    memo[i][j] += memo[i-1][j-l];
                    memo[i][j] %= mod;
                }
            }
        }
        System.out.println(memo[k][n]);
    }

    private static void bottomUp2(int k, int n) {

        memo[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = memo[i-1][j];
                if(j-1 >= 0){
                    memo[i][j] += memo[i][j-1];
                }
                memo[i][j] %= mod;
            }
        }
        System.out.println(memo[k][n]);
    }
} 
