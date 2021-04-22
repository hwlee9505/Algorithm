package navigation;

import java.util.LinkedList;
import java.util.Queue;

public class Network {

    public int getNetworkCount(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];
        for (int i = 0 ; i < n; i++) {
            if (!check[i]) {
                BFS(i, n, computers, check);
//                DFS(i, n, computers, check);
                answer++;
            }
        }
        return (answer);
    }

    public void BFS(int start, int n, int[][] computers, boolean[] check) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        check[start] = true;
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < n; i++) {
                if (i != temp && computers[temp][i] == 1) {
                    if (!check[i]) {
                        q.offer(i);
                        check[i] = true;
                    }
                }
            }
        }
    }

    public void DFS(int x, int n, int[][] computers, boolean[] check) {
        check[x] = true;
        for (int i = 0; i < n; i++) {
            if (x != i && computers[x][i] == 1) {
                if (!check[i]) {
                    DFS(i, n, computers, check);
                }
            }
        }
    }
}
