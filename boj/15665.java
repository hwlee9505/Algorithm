import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[] check = new int[9];
    public static int[] arr = new int[9];
    public static int[] num = new int[9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(temp, 0, n);

        int idx = 0;
        int selected = temp[0];
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            if (selected == temp[i]) {
                cnt++;
                continue;
            }
            check[idx] = cnt;
            num[idx] = selected;
            selected = temp[i];
            idx++;
            cnt = 1;
        }

        check[idx] = cnt;
        num[idx] = selected;

        n = idx + 1;

        System.out.println(recurse(0, n, m));

    }

    public static StringBuilder recurse(int idx, int n, int m) {

        // 1. 정답을 찾은 경우
        // 2. 불가능한 경우
        if (idx == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(num[arr[i]] + " ");
            }
            sb.append("\n");
            return sb;
        }

        // 3. 다음 경우 호출
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            arr[idx] = i;
            answer.append(recurse(idx + 1, n, m));
        }

        return answer;
    }
}
