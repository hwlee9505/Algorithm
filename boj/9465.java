import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//------------------------------------------------
// Dynamic Programming
// Dynamic Programming 은 Brute Force 로 풀 수 있다.
//------------------------------------------------
// D[i][j] = 2Xi 에서 얻을 수 있는 최대 점수, i번 열에서 뜯는 스티커는 j
//
// 한 열씩 봅시다.
// j = 0 -> 뜯지 않음
// j = 1 -> 위쪽 스티커를 뜯음
// j = 2 -> 아래쪽 스티커를 뜯음
//
// 1. D[i][0] (뜯지 않음)
//    i-1 열에서 스티커를 어떻게 뜯었는지 상관이 없다.
//    max(D[i-1][0], D[i-1][1], D[i-1][2])
//
// 2. D[i][1] (위쪽 스티커를 뜯음)
//    i-1 열에서 위쪽 스티커는 뜯으면 안된다.
//    max(D[i-1][0], D[i-1][2]) + cost[i][0]
//
// 3. D[i][2] (아래쪽 스티커를 뜯음)
//    i-1 열에서 아래쪽 스티커는 뜯으면 안된다.
//    max(D[i-1][0], D[i-1][1]) + cost[i][1]
//-----------------------------------------------
public class Main {

    static int[][] cost;
    static long[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        while (size-- > 0) {

            int n = Integer.parseInt(br.readLine());
            cost = new int[n + 1][2];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                cost[i][0] = Integer.parseInt(st1.nextToken());
            }
            for (int i = 1; i <= n; i++) {
                cost[i][1] = Integer.parseInt(st2.nextToken());
            }

            // 메모이제이션
            // j == 0 (뜯지 않음)
            // j == 1 (위쪽 스티커를 뜯음)
            // j == 2 (이레쩍 스티커를 뜯음)
            memo = new long[n + 1][3];

            System.out.println(bottomUp(n));
        }
    }

    public static long bottomUp(int n) {


        for (int i = 1; i <= n; i++) {
            memo[i][0] = Math.max(memo[i - 1][0], Math.max(memo[i - 1][1], memo[i - 1][2]));
            memo[i][1] = Math.max(memo[i - 1][0], memo[i - 1][2]) + cost[i][0];
            memo[i][2] = Math.max(memo[i - 1][0], memo[i - 1][1]) + cost[i][1];
        }

        return Math.max(memo[n][0], Math.max(memo[n][1], memo[n][2]));
    }
}
