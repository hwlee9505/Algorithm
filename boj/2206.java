import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {

    int x;
    int y;
    int z;

    public Pair(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {

    public static final int[] dx = {1, -1, 0, 0};
    public static final int[] dy = {0, 0, 1, -1};
    //                             동  서  남  북
    //                             ▶  ◀  ︎ ▼  ▲

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

        int[][][] dist = new int[n][m][2];

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0, 0, 0));
        dist[0][0][0] = 1;

        while (!q.isEmpty()) {

            Pair prior = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = prior.x + dx[i];
                int ny = prior.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // 1. 이동할 수 있는 구간
                if (arr[nx][ny] == 0 && dist[nx][ny][prior.z] == 0) {
                    q.offer(new Pair(nx, ny, prior.z));
                    dist[nx][ny][prior.z] = dist[prior.x][prior.y][prior.z] + 1;
                }

                // 2. 벽을 뚫고 가야하는 구간
                if (prior.z == 0 && arr[nx][ny] == 1 && dist[nx][ny][prior.z] == 0) {
                    q.offer(new Pair(nx, ny, prior.z + 1));
                    dist[nx][ny][prior.z + 1] = dist[prior.x][prior.y][prior.z] + 1;
                }
            }
        }
        if (dist[n - 1][m - 1][0] != 0 && dist[n - 1][m - 1][1] != 0) {
            System.out.println(Math.min(dist[n - 1][m - 1][0], dist[n - 1][m - 1][1]));
        } else if (dist[n - 1][m - 1][0] != 0) {
            System.out.println(dist[n - 1][m - 1][0]);
        } else if (dist[n - 1][m - 1][1] != 0) {
            System.out.println(dist[n - 1][m - 1][1]);
        } else {
            System.out.println(-1);
        }
    }
}
