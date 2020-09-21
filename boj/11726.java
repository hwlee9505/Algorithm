import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n + 1];

        System.out.println(go(n));

    }

    public static int go(int n) {

        if (n <= 2) {
            return n;
        } else {
            if (memo[n] > 0) {
                return memo[n];
            }
            memo[n] = go(n - 1) + go(n - 2);

        }
        // ✨ 계산 과정 중간중간 %를 취해주지 않으면
        // 계산 도중에 int 자료형 범위의 최댓값을 벗어나서 오버플로우가 발생한다.
        return memo[n] % 10007;
    }
}
