import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    //    N과 M (1)에서 check만 없애주면 된다.
    //    public static boolean[] check = new boolean[9];
    public static int[] arr = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println(recurse(0, n, m));
    }

    public static StringBuilder recurse(int idx, int n, int m) {
        // 1. 정답인 경우
        if (idx == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return sb;
        }
        // 2. 불가능한 경우

        // 3. 다음 경우 호출
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            
//            if(check[i] == false) continue;
//            check[i] = true;
            arr[idx] = i;
            answer.append(recurse(idx + 1, n, m));
//            check[i] = false;
        }
        return answer;
    }
}
