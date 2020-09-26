import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//------------------------------------------------------------------------------------------------------
// Dynamic Programming
//------------------------------------------------------------------------------------------------------
// D[i][j] = arr[1], ..., arr[i] 까지 포도주가 있을 때 , 마실 수 있는 포도주의 최대의 양, arr[i]는 j번 연속해서 마신 포도주임
//
// 1. D[i][0] = 0번 연속해서 마신 포도주 -> arr[i]를 마시지 않음
// D[i][0] = max(D[i-1][0], D[i-1][1], D[i-1][2])
// 2. D[i][1] = 1번 연속해서 마신 포도주 -> arr[i-1]를 마시지 않음
// 3. D[i][2] = 2번 연속해서 마신 포도주 -> arr[i-1]를 마시고, arr[i-2]는 마시지 않았어야 함
//------------------------------------------------------------------------------------------------------
// 1차원 점화식으로도 능하다. (마셨다 or 마시지 않았다. 2가지 이기 때문에)
//
// D[i] = i번째까지 최대양
//
// 1. 1번쨰 X            : D[i-1]
// 2. i번째 마심 - 1번 연속 : D[i-2] + A[i]
// 3. i번째 마심 - 2번 연속 : D[i-3] + A[i-1] + A[i]
//------------------------------------------------------------------------------------------------------
public class Main {

    public static int[] arr;
    public static long[][] memo;
    public static long[] memo2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 2차원 Top Down
        memo = new long[n + 1][3];
        System.out.println(bottomUp(n));

        // 1차원 Top Down
        memo2 = new long[n + 1];
        System.out.println(bottomUp2(n));
    }

    // 2차원 Top Down
    public static long bottomUp(int n) {

        memo[1][0] = 0;
        memo[1][1] = arr[1];
        memo[1][2] = arr[1];

        for (int i = 2; i <= n; i++) {
            // i번째 X
            memo[i][0] = Math.max(memo[i - 1][0], Math.max(memo[i - 1][1], memo[i - 1][2]));
            // i번째 마심 - 1번 연속
            memo[i][1] = memo[i - 1][0] + arr[i];
            // i번째 마심 - 2번 연속
            memo[i][2] = memo[i - 1][1] + arr[i];
        }
        return Math.max(memo[n][0], Math.max(memo[n][1], memo[n][2]));
    }

    // 1차원 Top Down
    public static long bottomUp2(int n) {

        memo2[1] = arr[1];
        if (n >= 2) {
            memo2[2] = arr[1] + arr[2];
        }

        for (int i = 3; i <= n; i++) {
            memo2[i] = memo2[i - 1];
            memo2[i] = memo2[i - 2] + arr[i];
            memo2[i] = memo2[i - 3] + arr[i - 1] + arr[i];
        }

        long answer = 0;

        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, memo2[i]);
        }

        return answer;
    }
}
