import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static boolean[] check = new boolean[9];
    private static int[] arr = new int[9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        recurse(0, n, m);
    }

    private static void recurse(int cnt, int n, int m) {

        // 1. 정답을 찾은 경우
        // 2. 불가능한 경우
        if (cnt >= m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
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
            arr[cnt] = i;
            recurse(cnt + 1, n, m);
            check[i] = false;
        }
    }
}

/////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<Integer> list = new ArrayList<>();
    public static boolean[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        check = new boolean[n + 1];

        recurse(n, m, 0);

    }

    public static void recurse(int n, int m, int idx) {

        // 1. 정답인 경우
        if (idx == m) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        // 2. 불가능한 경우

        // 3. 다음경우 호출
        for (int i = 1; i <= n; i++) {
            if (check[i] == false) {
                check[i] = true;
                list.add(i);
                recurse(n, m, idx + 1);
                list.remove(list.size() - 1);
                check[i] = false;
            }
        }
    }
}
