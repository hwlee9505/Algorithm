import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        for (int i = 0; i < arr.length; i++) {
            String temp = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = temp.charAt(j) - '0';
            }
        }

        int[][] dist = new int[n][m];

        for (int[] d : dist) {
            Arrays.fill(d, -1);
        }

        Queue<Pair> q = new LinkedList<>();
        Queue<Pair> nextQ = new LinkedList<>();

        q.offer(new Pair(0, 0));
        dist[0][0] = 0;

        while (!q.isEmpty()) {

            Pair priorPair = q.poll();

            for (int i = 0; i < 4; i++) {

                int nx = priorPair.x + dx[i];
                int ny = priorPair.y + dy[i];

                if ((0 <= nx && nx < n) && (0 <= ny && ny < m)) {
                    if (arr[nx][ny] == 0) {
                        if (dist[nx][ny] == -1) {
                            q.offer(new Pair(nx, ny));
                            dist[nx][ny] = dist[priorPair.x][priorPair.y];
                        }
                    }
                    if (arr[nx][ny] == 1) {
                        if (dist[nx][ny] == -1) {
                            nextQ.offer(new Pair(nx, ny));
                            dist[nx][ny] = dist[priorPair.x][priorPair.y] + 1;
                        }
                    }
                }
            }

            if(q.isEmpty()){
                q = nextQ;
                nextQ = new LinkedList<>();
            }
        }

        System.out.println(dist[n - 1][m - 1]);
    }
}
