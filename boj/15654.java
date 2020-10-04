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
        System.out.println(recurse(0, n, m));
    }

    public static StringBuilder recurse(int idx, int n, int m) {
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
        for (int i = 0; i < n; i++) {
            if (check[i]) {
                continue;
            }
            check[i] = true;
            arr[idx] = i;
            answer.append(recurse(idx + 1, n, m));
            check[i] = false;
        }
        return answer;
    }
}

///////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;
    public static boolean[] check;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        arr = new int[n+1];
        check = new boolean[n+1];
        int[] num = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < num.length; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num, 1, num.length);
        recurse(num, n, m, 0);
    }

    public static void recurse(int[] num, int n, int m, int idx) {

        // 1. 정받을 찾은 경우
        if (idx == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        // 2. 불가능한 경우

        // 3. 다음경우 호출

        for (int i = 1; i <= n; i++) {
            if (check[i] == false) {
                check[i] = true;
                arr[idx] = num[i];
                recurse(num, n, m, idx + 1);
                check[i] = false;
            }
        }

    }
}
