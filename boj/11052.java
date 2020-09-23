import java.io.*;
import java.util.StringTokenizer;
// Dynamic Programming [Overlapping SubProblem, Optimal Substructure]
//--------------------------------------------------------------------------------
//  1. 점화식을 구한다. 2. 문제를 작은문제로 나눈다.
//
//  D[N] = 카드 N개를 구매하는 최대비용
//--------------------------------------------------------------------------------
//  Q) 카드 N개를 구매하는 방법은?
//
//  카드 1개가 들어있는 카드팩을 구매하고, 카드 N-1개를 구매하는 최대 비용
//  카드 2개가 들어있는 카드팩을 구매하고, 카드 N-2개를 구매하는 최대 비용
//  ...
//  카드 N-1개가 들어있는 카드팩을 구매하고, 카드 1개를 구매하는 최대 비용
//  카드 N개가 들어있는 카드팩을 구매하고, 카드 0개를 구매하는 최대 비용
//--------------------------------------------------------------------------------
//  D[N] = max(memo[N],  p[i]              +            memo[N-i] ) (1 <= j <= N)
//                       ㄴ 카드 i개가 들어 있는 카드팩을 구매   ㄴ 카드 N-i개를 구매하는 최대 비용
public class Main {

    public static int[] p;
    public static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        p = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        // 1. Top Down
        memo = new int[n + 1];
        System.out.println(topDown(n));

        // 2. Bottom Up
        memo = new int[n + 1];
        System.out.println(bottomUp(n));
    }

    public static int topDown(int n) {
        // 하나 살 때 최대의 가격은 p[1] 이다.
        if (n == 1) {
            memo[n] = p[n];
            return memo[n];
        } else {
            if (memo[n] > 0) {
                return memo[n];
            }

            for (int i = 1; i <= n; i++) {
                memo[n] = topDown(n - i) + p[i] > memo[n] ? memo[n - i] + p[i] : memo[n];
//                if (topDown(n - i) + p[i] > memo[n]) {
//                    memo[n] = memo[n - i] + p[i];
//                } else {
//                    memo[n] = memo[n];
//                }
            }
            return memo[n];
        }
    }

    private static int bottomUp(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (memo[i] < p[j] + memo[i - j]) {
                    memo[i] = p[j] + memo[i - j];
                }
            }
        }
        return memo[n];
    }
}
