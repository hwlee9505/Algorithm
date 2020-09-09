import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr = new int[9];
    public static int[] num = new int[9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < n; i ++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num, 0, n);
        System.out.println(recurse(0, 0, n, m));

    }

    public static StringBuilder recurse(int idx, int selected, int n, int m) {

        // 1. 정답을 찾은 경우
        if (selected == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(num[arr[i]] + " ");
            }
            sb.append("\n");
            return sb;
        }

        // 2. 불가능한 경우
        if (idx >= n) {
            return new StringBuilder();
        }

        // 3. 다음 경우 호출
        StringBuilder answer = new StringBuilder();
        arr[selected] = idx;
        answer.append(recurse(idx + 1, selected + 1, n, m));
        arr[selected] = 0;
        answer.append(recurse(idx + 1, selected, n, m));
        return answer;
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static boolean[] check = new boolean[9];
    public static int[] arr = new int[9];
    public static int[] num = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num, 0, n);
        System.out.println(recurse(0, 0, n, m));
    }

    public static StringBuilder recurse(int idx, int start, int n, int m) {

        // 1. 정답을 찾은 경우
        if (idx == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(num[arr[i]] + " ");
            }
            sb.append("\n");
            return sb;
        }

        // 2. 불가능한 경우
        if (idx >= n) {
            return new StringBuilder();
        }

        StringBuilder answer = new StringBuilder();
        // 3. 다음 경우 호출
        for (int i = start; i < n; i++) {
            if (check[i]) {
                continue;
            }
            check[i] = true;
            arr[idx] = i;
            answer.append(recurse(idx + 1, i + 1, n, m));
            check[i] = false;
        }
        return answer;
    }
}
