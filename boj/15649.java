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

        recurse(0, n, m);
    }

    public static void recurse(int idx, int n, int m) {

        // 1. 정답을 찾은 경우
        // 2. 불가능한 경우
        if (idx == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i]);
                if (i != m - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            return;
        }


        // 3. 다음 경우 호출
        for (int i = 1; i <= n; i++) {
            if (check[i]) {
                continue;
            }
            check[i] = true;
            arr[idx] = i;
            recurse(idx + 1, n, m);
            check[i] = false;
        }
    }
}
