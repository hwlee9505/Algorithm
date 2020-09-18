import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 🍅토마토

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
        Queue<Pair> q = new LinkedList<>();

        // arr[i][j] ==  0  ->   🥭  -> dist[i][j] = -1
        // arr[i][j] ==  1  ->   🍅  -> dist[i][j] =  0  +  q.offer(new Pair(i,j));
        // arr[i][j] == -1  ->   🙅  -> dist[i][j] = -1
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;
                if (arr[i][j] == 1) {
                    q.offer(new Pair(i, j)); //✨ 이렇게 함으로써, 시작점이 여러 곳일 경우 해결
                    dist[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair priorPair = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = priorPair.x + dx[i];
                int ny = priorPair.y + dy[i];
                if ((0 <= nx && nx < n) && (0 <= ny && ny < m)) {
                    if (arr[nx][ny] == 0 && dist[nx][ny] == -1) {
                        q.offer(new Pair(nx, ny));
                        dist[nx][ny] = dist[priorPair.x][priorPair.y] + 1;
                    }
                }
            }
        }

        int answer = 0;

        for (int[] a : dist) {
            for (int i : a) {
                answer = Math.max(answer, i);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                // 익지 않은 🥭
                if (arr[i][j] == 0 && dist[i][j] == -1) {
                    answer = -1;
                }
            }
        }

        System.out.println(answer);
    }
}
