/**
 *	내가 좋아하는 dfs문제 이런거 좀 안틀렸으면 좋겠어
 */
public class CountAfterQuadCompression {
    public static void main(String[] args) {
        int[] arr = new Solution().solution(new int[][]{
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        });
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
        arr = new Solution().solution(new int[][]{
                {1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1},
                {0,0,0,0,1,1,1,1},
                {0,1,0,0,1,1,1,1},
                {0,0,0,0,0,0,1,1},
                {0,0,0,0,0,0,0,1},
                {0,0,0,0,1,0,0,1},
                {0,0,0,0,1,1,1,1}
        });
        for (int i : arr)
            System.out.print(i + " ");
    }

    static class Solution {
        public static int[] answer;
        public int[] solution(int[][] arr) {
            answer= new int[2];
            recurse(arr.length, arr, 0, 0);
            return answer;
        }

        public void recurse(int depth, int[][] arr, int x, int y)
        {
            if (depth == 0)
                return;
            int checkNum = checkValidation(depth, arr, x, y);
            if (checkNum == 0 || checkNum == 1)
            {
                if (checkNum == 0)
                    ++answer[0];
                else
                    ++answer[1];
                return;
            }
            recurse(depth / 2, arr, x, y);
            recurse(depth / 2, arr, x + depth / 2, y);
            recurse(depth / 2, arr, x, y + depth / 2);
            recurse(depth / 2, arr, x + depth / 2, y + depth / 2);
        }

        public int checkValidation(int depth, int[][] arr, int x, int y)
        {
            int ret = arr[x][y];
            for (int i = x; i < x + depth; i++)
                for (int j = y; j < y + depth; j++)
                    if (ret != arr[i][j])
                        return (-1);
            return (ret);
        }
    }
}

