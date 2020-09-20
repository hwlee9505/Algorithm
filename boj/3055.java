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
    //                              우  좌  하  상


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n][m];
        int[][] water = new int[n][m];
        int[][] dist = new int[n][m];

        // water[n][m], dist[n][m]의 모든 원소를 -1로 초기화
        initArr2D(water);
        initArr2D(dist);

        Queue<Pair> q = new LinkedList<>();

        // 1. 고슴도치 위치,   [Start]
        int sx = 0;
        int sy = 0;

        // 2. 두더지 동굴 위치, [Finish]
        int ex = 0;
        int ey = 0;

        for (int i = 0; i < arr.length; i++) {
            String s = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                char temp = s.charAt(j);
                arr[i][j] = temp;
                if (temp == '*') {           // 1. 물이 불어나는 시점
                    q.offer(new Pair(i, j)); // q에 삽입
                    water[i][j] = 0;         // water[][] = 0
                } else if (temp == 'S') {    // 2. 고슴도치 시작점
                    sx = i;
                    sy = j;
                } else if (temp == 'D') {
                    ex = i;
                    ey = j;
                } else if (temp == 'X') {
                } else { // temp == '.'
                }
            }
        }

        // 1. [물이 차는 시간] 💦💦💦💦💦💦💦💦💦💦💦💦💦💦💦💦💦💦💦💦💦💦💦💦💦💦💦💦💦💦💦💦💦💦💦
        while (!q.isEmpty()) {
            Pair prior = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = prior.x + dx[i];
                int ny = prior.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // [현재) 물이 뿜는 곳은 0, 나머지는 -1로 초기화된 상태]
                // [1) -1인 곳, 2) 두더지 동굴이 아닌곳, 3) 바위가 아닌곳]
                if (water[nx][ny] == -1 && arr[nx][ny] != 'D' && arr[nx][ny] != 'X') {
                    water[nx][ny] = water[prior.x][prior.y] + 1;
                    q.offer(new Pair(nx, ny));
                }
            }
        }

        // 2. [고슴도치의 이동] 🦔..🦔..🦔..🦔..🦔..🦔..🦔..🦔..🦔..🦔..🦔..🦔..🦔..🦔..🦔..🦔..
        q.offer(new Pair(sx, sy));
        dist[sx][sy] = 0;

        while (!q.isEmpty()) {

            Pair prior = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = prior.x + dx[i];
                int ny = prior.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // [현재) 고슴도치의 시작은 0, 나머지는 -1로 초기화된 상태]
                // [1) -1인 곳, 2) 바위가 아닌곳,
                // ✨✨✨3) 물에서 -1인곳 이거나 현 고슴도치 위치 +1 < 다음 물이 퍼지는 곳의 가중치]
                if (dist[nx][ny] == -1
                        && arr[nx][ny] != 'X'
                        && (water[nx][ny] == -1 || dist[prior.x][prior.y] + 1 < water[nx][ny])) {
                    dist[nx][ny] = dist[prior.x][prior.y] + 1;
                    q.offer(new Pair(nx, ny));
                }
            }
        }

        if (dist[ex][ey] == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(dist[ex][ey]);
        }
    }

    public static void printWater(int[][] arr) {
        for (int[] a : arr) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void initArr2D(int[][] arr) {
        for (int[] a : arr) {
            Arrays.fill(a, -1);
        }
    }
}
