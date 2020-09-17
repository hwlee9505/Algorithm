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

public class Main {

    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};
    //                             ->  <-  |  ^
    //                                     v  |
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = temp.charAt(j) - '0';
            }
        }

        int cnt = 0;
        int[][] group = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && group[i][j] == 0) {
                    dfs(arr, group, i, j, ++cnt, n);
                }
            }
        }

        int[] answer = new int[cnt];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (group[i][j] != 0) {
                    answer[group[i][j] - 1] += 1;
                }
            }
        }

        Arrays.sort(answer);
        System.out.println(cnt);
        for (int i = 0; i < cnt; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void dfs(int[][] arr, int[][] group, int x, int y, int cnt, int n) {
        group[x][y] = cnt;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if ((0 <= nx && nx < n) && (0 <= ny && ny < n)) {
                if (arr[nx][ny] == 1 && group[nx][ny] == 0) {
                    dfs(arr, group, nx, ny, cnt, n);
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
