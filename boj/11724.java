import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 인접 리스트
    public static ArrayList<Integer>[] arr;
    public static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            arr[from].add(to);
            arr[to].add(from);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(arr[i]);
        }

//        check = new boolean[n + 1];
//        printArr();
//        dfs(1);

        check = new boolean[n + 1];
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if(check[i] == false){
                bfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int x) {

        check[x] = true;
//        System.out.print(x + " ");
        for (int y : arr[x]) {
            if (check[y] == false) {
                dfs(y);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        check[start] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
//            System.out.print(temp + " ");
            for (int y : arr[temp]) {
                if (check[y] == false) {
                    check[y] = true;
                    queue.offer(y);
                }
            }
        }
    }

    public static void printArr() {

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
