import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {
    public static void main(String[] args) {
        int[] arr = new Solution().solution(6, 4, new int[][]{
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        });
        System.out.println("arr[0] = " + arr[0]);
        System.out.println("arr[1] = " + arr[1]);
    }

    static class Solution {
        public static int[] dx = {0, 0, -1, 1};
        public static int[] dy = {-1, 1, 0, 0};
        static class Position
        {
            int x;
            int y;
            public Position(int x, int y)
            {
                this.x = x;
                this.y = y;
            }
        }
        public int[] solution(int m, int n, int[][] picture) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;

            int[] answer = new int[2];
            boolean[][] check = new boolean[picture.length][picture[0].length];
            for (int i = 0; i < check.length; i++)
                for (int j = 0; j < check[0].length; j++)
                    if (picture[i][j] == 0)
                        check[i][j] = true;
            for (int i = 0; i < check.length; i++)
            {
                for (int j = 0; j < check[0].length; j++)
                {
                    if (!check[i][j])
                    {
                        numberOfArea++;
                        int cnt = 1;
                        int value = picture[i][j];
                        Queue<Position> q = new LinkedList<>();
                        q.offer(new Position(i, j));
                        check[i][j] = true;
                        while (!q.isEmpty())
                        {
                            Position now = q.poll();
                            for (int k = 0; k < 4; k++)
                            {
                                int nextX = now.x + dx[k];
                                int nextY = now.y + dy[k];
                                if ((0 <= nextX && nextX < picture.length) && (0 <= nextY && nextY < picture[0].length))
                                {
                                    if (!check[nextX][nextY] && picture[nextX][nextY] == value)
                                    {
                                        check[nextX][nextY] = true;
                                        q.offer(new Position(nextX, nextY));
                                        cnt++;
                                    }
                                }
                            }
                        }
                        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                    }
                }
            }
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }
    }
}


