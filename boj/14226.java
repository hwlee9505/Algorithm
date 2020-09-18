import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N개의 이모티콘을 만드는데 걸리는 시간의 최솟값을 구하는 문제
        int n = Integer.parseInt(br.readLine());

        int[][] dist = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<Integer> q = new LinkedList<>();

        // 👉 현재 상황 (default로 어떤 값을 설정해 놓아야 하는가)
        //    영선이가 이미 화면에 이모티콘 1개를 입력해 놓은 상태
        //    클립보드에는 이모티콘이 없다.
        q.offer(1);
        q.offer(0);

        dist[1][0] = 0;

        while (!q.isEmpty()) {
            int s = q.poll();
            int c = q.poll();

            // 1. 복사: (s,c)->(s,s)
            // 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장
            if (dist[s][s] == -1) {
                dist[s][s] = dist[s][c] + 1;
                q.offer(s);
                q.offer(s);
            }

            // 2. 붙여넣기: (s,c)->(s+c,c)
            // 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
            if (s + c <= n && dist[s + c][c] == -1) {
                dist[s + c][c] = dist[s][c] + 1;
                q.offer(s + c);
                q.offer(c);
            }

            // 3. 삭제: (s,c)->(s-1,c)
            // 화면에 있는 이모티콘 중 하나를 삭제
            if (s - 1 >= 0 && dist[s - 1][c] == -1) {
                dist[s - 1][c] = dist[s][c] + 1;
                q.offer(s - 1);
                q.offer(c);
            }
        }
 
        int answer = -1;
        for (int i = 0; i <= n; i++) {
            if (dist[n][i] != -1) {
                if (answer == -1 || answer > dist[n][i]) {
                    answer = dist[n][i];
                }
            }
        }
        System.out.println(answer);
    }
}
