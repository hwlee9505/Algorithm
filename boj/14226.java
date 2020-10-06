import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {

    int s; // Screen
    int c; // ClipBoard

    public Pair(int s, int c) {
        this.s = s;
        this.c = c;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N개의 이모티콘을 만드는데 걸리는 시간의 최솟값을 구하는 문제
        int n = Integer.parseInt(br.readLine());

        int[][] dist = new int[n + 1][n + 1];

        for (int[] d : dist) {
            Arrays.fill(d, -1);
        }

        Queue<Pair> q = new LinkedList<>();

        // 👉 현재 황 (default 로 어떤 값을 설정해 놓아야 하는가)
        //    영선이가 이미 화면에 이모티콘 1개를 입력해 놓은 상태
        //    클립보드에는 이모티콘이 없다.
        q.offer(new Pair(1, 0)); //  화면에 이모티콘 1개 : 클립보드에 이모티콘 0개

        dist[1][0] = 0;

        while (!q.isEmpty()) {

            Pair p = q.poll();

            // 1. 복사 : (s,s) -> (s,s)
            // 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            if (dist[p.s][p.s] == -1) {
                dist[p.s][p.s] = dist[p.s][p.c] + 1;
                q.offer(new Pair(p.s, p.s));
            }

            // 2. 붙여넣기 : (s,c) -> (s+c,c)
            // 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            if (p.s + p.c <= n && dist[p.s + p.c][p.c] == -1) {
                dist[p.s + p.c][p.c] = dist[p.s][p.c] + 1;
                q.offer(new Pair(p.s + p.c, p.c));
            }

            // 3. 삭제 : (s,c) -> (s-1, c)
            // 화면에 있는 이모티콘 중 하나를 삭제한다.
            if (p.s - 1 >= 0 && dist[p.s - 1][p.c] == -1) {
                dist[p.s - 1][p.c] = dist[p.s][p.c] + 1;
                q.offer(new Pair(p.s - 1, p.c));
            }
        }

        int answer = -1;

        for (int i = 0; i < dist.length; i++) {
            if (dist[n][i] != -1) {
                if (answer == -1 || answer > dist[n][i]) {
                    answer = dist[n][i];
                }
            }
        }
        System.out.println(answer);
    }
}
