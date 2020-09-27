import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;
    public static int[] memo;
    public static int[] memo2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        memo = new int[n];
        memo2 = new int[n];
        bottomUp(n);
    }

    public static void bottomUp(int ) {

        for (int i = 0; i < n; i++) {
            memo[i] = 1;
            memo2[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && memo[i] < memo[j] + 1) {
                    memo[i] = memo[j] + 1;
                }
            }
        }

        // 거꾸로 시작해야지
        for (int i = n - 1; i >= 0; i--) {
            memo2[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j] && memo2[j] + 1 > memo2[i]) {
                    memo2[i] = memo2[j] + 1;
                }
            }
        }


        int answer = memo[0] + memo2[0] -1;
        for (int i = 0; i < n; i++) {
            if (answer < memo[i] + memo2[i] -1) {
                answer = memo[i] + memo2[i] -1;
            }
        }

        System.out.println(answer);
    }
}
