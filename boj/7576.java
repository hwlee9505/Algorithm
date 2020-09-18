import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[][] dist = new int[n][m];
//        boolean[][] check = new boolean[n][m];

        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[0].length; j++) {

                // arr[i][j] == 0 or -1 일때, dist[i][j] = -1
                arr[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;

                // arr[i][j] == 1 일때, dist[i][j] = 0
                // q에 삽입
                if (arr[i][j] == 1) {
                    q.offer(new Pair(i, j));
                    dist[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair priorPair = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = priorPair.x + dx[k];
                int ny = priorPair.y + dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (arr[nx][ny] == 0 && dist[nx][ny] == -1) {
                        q.offer(new Pair(nx, ny));
                        dist[nx][ny] = dist[priorPair.x][priorPair.y] + 1;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 익은 🍅 총 걸리는 일수
                ans = Math.max(ans, dist[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //✨✨ 익지 않은 곳 🥭
                if (arr[i][j] == 0 && dist[i][j] == -1) {
                    ans = -1;
                }
            }
        }
        System.out.println(ans);
    }
}
