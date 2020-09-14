import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge {
    int from;
    int to;

    public Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 인접 행렬 생성
        boolean[][] check = new boolean[n][n];

        // 인접 리스트
        ArrayList<Integer>[] g = (ArrayList<Integer[]) new ArrayList[n];

        // Edge클래스를 담는 list
        ArrayList<Edge> edges = new ArrayList<>();

        // graph 초기화 과정
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            edges.add(new Edge(from, to));
            edges.add(new Edge(to, from));

            check[from][to] = check[to][from] = true;

            // 인접리스트 매달기
            g[from].add(to);
            g[to].add(from);
        }

        // mx2를 하는 이유? - edges of ArrayList<Edge>는 두 배가 된다.
        m *= 2;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int A = edges.get(i).from;
                int B = edges.get(i).to;
                int C = edges.get(j).from;
                int D = edges.get(j).to;

                if (A == B || A == C || A == D || B == C || B == D || C == D) {
                    continue;
                }

                if (!check[B][C]) {
                    continue;
                }

                for (int E : g[D]) {
                    if (A == E || B == E || C == E || D == E) {
                        continue;
                    }
                    System.out.println(1);
                    System.exit(0);
                }
            }
        }
        System.out.println(0);
    }
}
