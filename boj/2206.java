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

    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nexToken());

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

                // 1. 이동할 수 있는 곳을 밟을 때
                // [벽이 없는 곳이어야 한다, 한번도 밟지 않은 곳이어야 한다. (+전에 벽을 부셨건 말건 상관 없다.)]
                if (arr[nx][ny] == 0 && dist[nx][ny][prior.z] == 0) {
                    dist[nx][ny][prior.z] = dist[prior.x][prior.y][prior.z] + 1;
                    q.offer(new Pair(nx, ny, prior.z));
                }

                // 2. 벽을 부수려 할 때
                // [prior.z는 0(부순 적이 없어야 한다.), 벽이 있는 곳이어야 한다, 한번도 밟지 않은 곳이어야 한다.]
                if (prior.z == 0 && arr[nx][ny] == 1 && dist[nx][ny][prior.z] == 0) {
                    dist[nx][ny][prior.z + 1] = dist[prior.x][prior.y][prior.z] + 1;
                    q.offer(new Pair(nx, ny, prior.z + 1));
                }
            }
        }

        // 벽을 부순게 정답일 수 도 있고
        // 벽을 안부순게 정답을 될 수 도 있다.
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
