import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static boolean[] check = new boolean[9];
    public static int[] arr = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        recurse(0, 1, n, m);

    }

    // n과 m(1) + 오름차순 (int start 사용)
    public static void recurse(int cnt, int start, int n, int m) {

        // 1. 정답인 경우
        // 2. 불가능한 경우
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        // 3. 다음 경우 호출
        // start를 사용함으로서 (i+1 보다 크거나 같은 수를 구현)
        for (int i = start; i <= n; i++) {
            if (check[i]) {
                continue;
            }
            check[i] = true;
            arr[cnt] = i;
            recurse(cnt + 1, i + 1, n, m);
            check[i] = false;
        }
    }
}
