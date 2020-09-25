import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//------------------------------------------
// Dynamic Programming
//------------------------------------------
// D[N] = N자리 이친수의 개수
//------------------------------------------
// D[i][j] = i자리 이친수의 개수 + 마지막은 j이 였음
//
// D[i][j] = D[i-1][0] + D[i-1][1] (j==0)
// D[i][j] = D[i-1][0] (j==1)
//------------------------------------------
// 이 문제는 0과 1밖에 없기 때문에 1차원 점화식으로도 풀 수 있다.
public class Main {

    public static long[][] memo;
    public static long[] memo2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        memo = new long[n + 1][2];
        System.out.println(bottomUp(n));

        memo2 = new long[n+1];
        System.out.println(bottomUp2(n));
    }

    public static long bottomUp(int n) {

        // 0자리의 경우의 수는 있을 수 X.
//        memo[0][0] = 0;
//        memo[0][1] = 0;

        // 1자리 이친수의 개수 + 마지막은 0, 0으로 시작하면 X
        memo[1][0] = 0;
        // 1자리 이친수의 개수 + 마지막은 1
        memo[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 1; j++) {
                if (j == 0) {
                    memo[i][j] = memo[i - 1][0] + memo[i - 1][1];
                    continue;
                }
                memo[i][j] = memo[i - 1][0];
            }
        }

        return memo[n][0] + memo[n][1];
    }

    // 0과 1밖에 없으므로 1차원 점화식으로 풀 수 있다.
    public static long bottomUp2(int n){
        // 1자리 이친수의 개수는 1로만
        memo2[1] = 1;
        
        if(n >= 2){
            memo2[2] = 1;
        }
        
        for(int i = 3; i <= n; i ++){
            memo2[i] = memo2[i-1] + memo2[i-2];
        }
        return memo2[n];
    }
}
