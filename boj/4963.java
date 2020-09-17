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

    public static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {

            st = new StringTokenizer(br.readLine());
            int[][] arr, check;

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                return;
            }

            arr = new int[h][w];

            for (int i = 0; i < arr.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            check = new int[h][w];

            int cnt = 0;

            for (int i = 0; i < check.length; i++) {
                for (int j = 0; j < check[0].length; j++) {
                    if (arr[i][j] == 1 && check[i][j] == 0) {
                        bfs(arr, check, i, j, ++cnt, w, h);
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    public static void dfs(int[][] arr, int[][] check, int x, int y, int cnt, int w, int h) {

        check[x][y] = cnt;
        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if ((0 <= nx && nx < h) && (0 <= ny && ny < w)) {
                if (arr[nx][ny] == 1 && check[nx][ny] == 0) {
                    dfs(arr, check, nx, ny, cnt, w, h);
                }
            }
        }

    }

    public static void bfs(int[][] arr, int[][] check, int x, int y, int cnt, int w, int h) {

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y));
        check[x][y] = cnt;

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            for (int k = 0; k < 8; k++) {
                int nx = temp.x + dx[k];
                int ny = temp.y + dy[k];

                if ((0 <= nx && nx < h) && (0 <= ny && ny < w)) {
                    if (arr[nx][ny] == 1 && check[nx][ny] == 0) {
                        q.offer(new Pair(nx,ny));
                        check[nx][ny] = cnt;
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
