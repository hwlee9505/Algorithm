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

        if (n == 1) {
            return 1;
        } 
        else if (n == 2) {
            return 3;
        } else {
            if (memo[n] > 0) {
                return memo[n];
            }
            memo[n] = go(n - 1) + 2 * go(n - 2);
            memo[n] %= 10007;
            return memo[n];
        }
    }
}
