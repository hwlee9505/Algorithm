import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *    (1, 1)에서 출발하여 (N, M)의 위치로 이동한다고 되어있는데
 *    다른분들은 (0, 0)에서 출발하여 (N-1, M-1)로 문제를 푼다.
 *
 *    => 배열 인덱스가 0부터 시작이니깐 그렇게 푸는 분도 있고
 *       한칸 크게 잡아서 11 nm으로 잡는 분들도 있다.
 */

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < arr.length; i++) {
            String temp = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = temp.charAt(j) - '0';
            }
        }

        int[][] dist = new int[n][m];
        boolean[][] check = new boolean[n][m];

        // (1, 1) -> (n, m)의 거리 비용
        // == (0, 0) -> (n-1, m-1)의 거리 비용
        int startX = 0;
        int startY = 0;
        bfs(arr, dist, check, startX, startY, n, m);

        System.out.println(dist[n - 1][m - 1]);

//        printDist(dist);
    }

    // 최단 거리를 구하기 위해선 bfs를 사용
    public static void bfs(int[][] arr, int[][] dist, boolean[][] check, int startX, int startY, int n, int m) {
        Queue<Pair> q = new LinkedList<>();
        // 1. queue 자료구조에 (0,0) 넣고
        q.offer(new Pair(startX, startY));
        // 2. dist(0,0)에 1을 넣고
        dist[startX][startY] = 1;
        // 3. check(0,0)에 true로
        check[startX][startY] = true;

        while (!q.isEmpty()) {
            Pair priorPair = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = priorPair.x + dx[i];
                int ny = priorPair.y + dy[i];
                if ((0 <= nx && nx < n) && (0 <= ny && ny < m)) {
                    if (arr[nx][ny] == 1 && check[nx][ny] == false) {
                        q.offer(new Pair(nx, ny));
                        dist[nx][ny] = dist[priorPair.x][priorPair.y] + 1;  // ✨ 이전을 더 하는게 중요
                        check[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void printDist(int[][] dist) {

        for (int[] a : dist) {
            for (int k : a) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}
