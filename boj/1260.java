/*
6 7 1
1 2
1 5
2 3
2 5
3 4
4 5
4 6
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static ArrayList<Integer>[] arr;
    public static boolean[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

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

        check = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            Collections.sort(arr[i]);
        }

        dfs(start);
        System.out.println();
        check = new boolean[n + 1];
        bfs(start);
        System.out.println();
    }

    public static void dfs(int x) {

        check[x] = true;
        System.out.print(x + " ");
        for (int y : arr[x]) {
            if (check[y] == false) {
                dfs(y);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);
        check[start] = true;
        while(!q.isEmpty()){
            int x = q.poll();
            System.out.print(x + " ");
            for(int y : arr[x]){
                if(check[y] == false){
                    check[y] = true;
                    q.offer(y);
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
