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

-------------------------------------------------------------------------------

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {

    int from;
    int to;

    public Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }

    // 그냥 별거없다. 정렬 기준 세우는 것이다.
    @Override
    public int compareTo(Edge that) {
        if (this.from < that.from) {
            return -1;
        } else if (this.from == that.from) {
            if (this.to < that.to) {
                return -1;
            } else if (this.to == that.to) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Edge{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}

// 2. 간선 리스트 소스
public class Main {

    // 이 두가지 자료구조를 이용해서 간선 리스트를 만듬.
    public static Edge[] edge;
    public static int[] cnt;

    public static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        edge = new Edge[m * 2];
        cnt = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edge[i] = new Edge(from, to);
            edge[m + i] = new Edge(to, from);
        }

        m *= 2;
        Arrays.sort(edge);

        for (int i = 0; i < m; i++) {
            cnt[edge[i].from]++;        // 각 노드(vertex)의 차수 개수, from 의 개수 만큼 +
        }

        // 간선 리스트 특) 값이 축적 됨.
        for (int i = 1; i <= n; i++) {
            cnt[i] += cnt[i - 1];
        }

        check = new boolean[n + 1];
        dfs(start);
        System.out.println();
        check = new boolean[n + 1];
        bfs(start);


    }

    private static void dfs(int node) {
        check[node] = true;
        System.out.print(node + " ");
        for (int i = cnt[node - 1]; i < cnt[node]; i++) {
            int next = edge[i].to;
            if (check[next] == false) {
                dfs(next);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        check[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int i = cnt[node - 1]; i < cnt[node]; i++) {
                int next = edge[i].to;
                if (check[next] == false) {
                    check[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
