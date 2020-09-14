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

///////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair {

    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

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

        for (int i = 1; i <= n; i++) {
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

        check = new boolean[n + 1];
        dfs(start);
        System.out.println();
        check = new boolean[n + 1];
        bfs(start);

    }

    public static void dfs(int x) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(x, 0));
        check[x] = true;
        System.out.print(x + " ");
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            int node = p.first;
            int start = p.second;
            for (int i = start; i < arr[node].size(); i++) {
                int next = arr[node].get(i);
                if(check[next] == false){
                    System.out.print(next + " ");
                    check[next] = true;
                    stack.push(new Pair(node, i + 1)) ;
                    stack.push(new Pair(next, 0));
                    break;
                }
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        check[start] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " ");
            for (int i : arr[x]) {
                if (check[i] == false) {
                    check[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
