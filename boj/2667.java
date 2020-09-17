/*
 *      그래프 문제인데, 인접 행렬이나 인접 리스트를 만들어야 할까?
 *
 *      NO.
 *      왜냐하면 2차원 배열 상에서는 한 정점과 연결되어 있는 간선을 그냥
 *      위, 왼쪽, 오른쪽, 아래 4번만 살펴보면 되기 때문에
 *      이미 이 자체만으로도 효율적인데 굳이 추가적인 자료구조를 만드는 것은 비효율적이다.
 *
 *      DFS나 BFS 알고리즘을 이용해서 어떻게 이어져있는지 확인할 수 있다.
 *      d[i][j] = (i,j)를 방문안했으면 0, 했으면 단지 번호
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
    //                             ->  <-  |  ^
    //                                     v  |
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        int[][] check = new int[n][n];

        for (int i = 0; i < arr.length; i++) {
            String temp = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = temp.charAt(j) - '0';
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && check[i][j] == 0) {
                    dfs(arr, check, i, j, ++cnt, n);
//                    bfs(arr, check, i, j, ++cnt, n);
                }
            }
        }


        int[] answer = new int[cnt];

        for (int i = 0; i < check.length; i++) {
            for (int j = 0; j < check[0].length; j++) {
                if (check[i][j] != 0) {
                    answer[check[i][j] - 1]++;
                }
            }
        }

        Arrays.sort(answer);

        System.out.println(cnt);
        for(int i : answer){
            System.out.println(i);
        }
    }

    // 1. Depth_First_Search
    public static void dfs(int[][] arr, int[][] check, int x, int y, int cnt, int n) {
        check[x][y] = cnt;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if ((0 <= nx && nx < n) && (0 <= ny && ny < n)) {
                if (arr[nx][ny] == 1 && check[nx][ny] == 0) {
                    dfs(arr, check, nx, ny, cnt, n);
                }
            }
        }
    }

    // 2. Breadth_First_Search
    public static void bfs(int[][] arr, int[][] check, int x, int y, int cnt, int n) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y));
        check[x][y] = cnt;
        while (!q.isEmpty()) {

            Pair temp = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = temp.x + dx[k];
                int ny = temp.y + dy[k];
                if ((0 <= nx && nx < n) && (0 <= ny && ny < n)) {
                    if (arr[nx][ny] == 1 && check[nx][ny] == 0) {
                        q.offer(new Pair(nx, ny));
                        check[nx][ny] = cnt;
                    }
                }
            }
        }
    }
}
