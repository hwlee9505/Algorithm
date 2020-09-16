import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());


            // 준비물 1. 인접 리스트
            ArrayList<Integer>[] arr = new ArrayList[n + 1];

            for (int i = 0; i <= n; i++) {
                arr[i] = new ArrayLis<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                arr[from].add(to);
                arr[to].add(from);
            }

            // 준비물 2. 피아식별 color
            int[] color = new int[n + 1];
            boolean ok = true;
            for (int i = 1; i <= n; i++) {
                if (color[i] == 0) {
                    dfs(arr, color, i, 1);
                }
            }

            for (int i = 1; i <= n; i++) {
                for (int j : arr[i]) {
                    if (color[i] == color[j]) {
                        ok = false;
                    }
                }
            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

//            printArr(arr);
        }
    }

    public static void dfs(ArrayList<Integer>[] arr, int[] color, int x, int c) {
        color[x] = c;
        for (int y : arr[x]) {
            if (color[y] == 0) {
                dfs(arr, color, y, 3 - c);  //  1하고 2는 다른 색
            }
        }
    }

    // 인접 리스트 출력
    public static void printArr(ArrayList<Integer>[] arr) {
        int idx = 0;
        for (ArrayList<Integer> a : arr) {
            System.out.print(idx++ + ": ");
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
