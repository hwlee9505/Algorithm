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

        int startX = 0;
        int startY = 0;
        
        bfs(arr, dist, check, startX, startY, n, m);

        System.out.println(dist[n - 1][m - 1]);
//        printArr(dist);
    }

    public static void bfs(int[][] arr, int[][] dist, boolean[][] check, int x, int y, int n, int m) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y));
        check[x][y] = true;
        dist[x][y] = 1;
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];
                if ((0 <= nx && nx < n) && (0 <= ny && ny < m)) {
                    if (check[nx][ny] == false && arr[nx][ny] == 1) {
                        q.offer(new Pair(nx, ny));
                        dist[nx][ny] = dist[pair.x][pair.y] + 1;
                        check[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void printArr(int[][] arr) {
        for (int[] a : arr) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
