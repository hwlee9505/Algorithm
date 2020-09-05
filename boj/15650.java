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

        System.out.println(recurse(0, 1, n, m));

    }

    // n과 m(1) + 오름차순 (int start 사용)
    public static StringBuilder recurse(int cnt, int start, int n, int m) {

        // 1. 정답인 경우
        // 2. 불가능한 경우
        if (cnt == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return sb;
        }

        StringBuilder answer = new StringBuilder();

        // 3. 다음 경우 호출
        for (int i = start; i <= n; i++) {
            if (check[i]) {
                continue;
            }
            check[i] = true;
            arr[cnt] = i;
            answer.append(recurse(cnt + 1, i + 1, n, m));
            check[i] = false;
        }
        return answer;
    }
}

///////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr = new int[9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        recurse(1,0,n,m);
    }

    public static void recurse(int idx, int selected, int n, int m) {

        // 1. 정답을 찾은 경우
        if (selected == m) {
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
        arr[selected] = idx;
        recurse(idx + 1, selected + 1, n, m);
        arr[selected] = 0;
        recurse(idx + 1, selected, n, m);
    }
}

////////////////////////////////////////////////////////////////////////////////////////

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
