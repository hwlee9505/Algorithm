import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 아직 어려운 코드

public class Main {

    public static int[] cnt = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println(recurse(1, 0, n, m));

    }

    public static StringBuilder recurse(int idx, int selected, int n, int m) {

        // 1. 정답을 찾은 경우
        if (selected == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                for(int j = 1; j <= cnt[i]; j ++){
                    sb.append(i);
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return sb;
        }
        // 2. 불가능한 경우
        if (idx > n) {
            return new StringBuilder();
        }

        // 3. 다음 경우 호출
        StringBuilder answer = new StringBuilder();

        for (int i = m - selected; i >= 1; i--) {
            cnt[idx] = i;
            answer.append(recurse(idx + 1, selected + i, n, m));
        }

        cnt[idx] = 0;
        answer.append(recurse(idx +1, selected, n, m));

        return answer;
    }
}

////////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 비내림 차순

public class Main {

    public static boolean[] check = new boolean[8];
    public static int[] arr = new int[8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        recurse(0, 1, n, m);
    }

    public static void recurse(int idx, int start, int n, int m) {
        // 1. 정답을 찾은 경우
        if (idx == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        // 2. 불가능한 경우
        if (idx > n) {
            return;
        }

        // 3. 다음 경우 호출
        for (int i = start; i <= n; i++) {
            arr[idx] = i;
            recurse(idx + 1, i, n, m);
        }
    }
}
