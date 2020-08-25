import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Brute Force 3 단계
 * <p>
 * 1. 문제의 가능한 경우의 수를 계산해본다. (손으로, Permutation or Combination)
 * 2. 가능한 모든 방법을 다 만들어 본다. (하나도 빠짐없어야 한다.)
 * 3. 각각의 방법을 이용해 답을 구해본다.
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ySize = Integer.parseInt(st.nextToken());
        int xSize = Integer.parseInt(st.nextToken());

        int[][] arr2D = new int[ySize][xSize];

        for (int i = 0; i < arr2D.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr2D[0].length; j++) {
                arr2D[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //        for(int[] xArr : arr2D){
        //            for(int module : xArr){
        //                System.out.print(module + " ");
        //            }
        //            System.out.println();
        //        }


        int sum = 0;
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[0].length; j++) {

                //  1.
                //  🟥🟦🟦🟦
                if (j + 3 < xSize) {
                    int temp = arr2D[i][j] + arr2D[i][j + 1] + arr2D[i][j + 2] + arr2D[i][j + 3];
                    sum = Math.max(sum, temp);
//                    if(sum < temp){
//                        sum = temp;
//                    }
                }

                //  2.
                //  🟥
                //  🟦
                //  🟦
                //  🟦
                if (i + 3 < ySize) {
                    int temp = arr2D[i][j] + arr2D[i + 1][j] + arr2D[i + 2][j] + arr2D[i + 3][j];
                    sum = Math.max(sum, temp);
                }

                //  3.
                //  🟥🟨
                //  🟨🟨
                if ((j + 1 < xSize) && (i + 1 < ySize)) {
                    int temp = arr2D[i][j] + arr2D[i][j + 1] + arr2D[i + 1][j] + arr2D[i + 1][j + 1];
                    sum = Math.max(sum, temp);
                }

                //  4.
                //  🟥
                //  🟧
                //  🟧🟧
                if ((j + 1 < xSize) && (i + 2 < ySize)) {
                    int temp = arr2D[i][j] + arr2D[i + 1][j] + arr2D[i + 2][j] + arr2D[i + 2][j + 1];
                    sum = Math.max(sum, temp);
                }

                //  5.
                //  🟥🟧
                //    🟧
                //    🟧
                if ((j + 1 < xSize) && (i + 2 < ySize)) {
                    int temp = arr2D[i][j] + arr2D[i][j + 1] + arr2D[i + 1][j + 1] + arr2D[i + 2][j + 1];
                    sum = Math.max(sum, temp);
                }


                //  6.
                //  🟥🟧🟧
                //  🟧
                if ((j + 2 < xSize) && (i + 1) < ySize) {
                    int temp = arr2D[i][j] + arr2D[i][j + 1] + arr2D[i][j + 2] + arr2D[i + 1][j];
                    sum = Math.max(sum, temp);
                }

                //  7.
                //     🟧
                //  🟥🟧🟧
                if ((j + 2 < xSize) && (i > 0)) {
                    int temp = arr2D[i][j] + arr2D[i][j + 1] + arr2D[i][j + 2] + arr2D[i - 1][j + 2];
                    sum = Math.max(sum, temp);
                }

                //  8.
                //    🟥
                //    🟧
                //  🟧🟧
                if ((j > 0) && (i + 2 < ySize)) {
                    int temp = arr2D[i][j] + arr2D[i + 1][j] + arr2D[i + 2][j] + arr2D[i + 2][j - 1];
                    sum = Math.max(sum, temp);
                }

                //  9.
                //  🟥🟧
                //  🟧
                //  🟧
                if ((j + 1 < xSize) && (i + 2 < ySize)) {
                    int temp = arr2D[i][j] + arr2D[i][j + 1] + arr2D[i + 1][j] + arr2D[i + 2][j];
                    sum = Math.max(sum, temp);
                }


                //  10.
                //  🟥🟧🟧
                //     🟧
                if ((j + 2 < xSize) && (i + 1 < ySize)) {
                    int temp = arr2D[i][j] + arr2D[i][j + 1] + arr2D[i][j + 2] + arr2D[i + 1][j + 2];
                    sum = Math.max(sum, temp);
                }

                //  11.
                //  🟥
                //  🟧🟧🟧
                if ((j + 2 < xSize) && (i + 1 < ySize)) {
                    int temp = arr2D[i][j] + arr2D[i + 1][j] + arr2D[i + 1][j + 1] + arr2D[i + 1][j + 2];
                    sum = Math.max(sum, temp);
                }

                //  12.
                //  🟥
                //  🟩🟩
                //    🟩
                if ((j + 1 < xSize) && (i + 2 < ySize)) {
                    int temp = arr2D[i][j] + arr2D[i + 1][j] + arr2D[i + 1][j + 1] + arr2D[i + 2][j + 1];
                    sum = Math.max(sum, temp);
                }

                //  13.
                //    🟥
                //  🟩🟩
                //  🟩
                if ((j > 0) && (i + 2 < ySize)) {
                    int temp = arr2D[i][j] + arr2D[i + 1][j] + arr2D[i + 1][j - 1] + arr2D[i + 2][j - 1];
                    sum = Math.max(sum, temp);
                }

                //  14.
                //    🟩🟩
                //  🟥🟩
                if ((j + 2 < xSize) && (i > 0)) {
                    int temp = arr2D[i][j] + arr2D[i][j + 1] + arr2D[i - 1][j + 1] + arr2D[i - 1][j + 2];
                    sum = Math.max(sum, temp);
                }

                //  15.
                //  🟥🟩
                //    🟩🟩
                if ((j + 2 < xSize) && (i + 1 < ySize)) {
                    int temp = arr2D[i][j] + arr2D[i][j + 1] + arr2D[i + 1][j + 1] + arr2D[i + 1][j + 2];
                    sum = Math.max(sum, temp);
                }

                //  16.
                //  🟥🟪🟪
                //    🟪
                if ((j + 2 < xSize) && (i + 1 < ySize)) {
                    int temp = arr2D[i][j] + arr2D[i][j + 1] + arr2D[i][j + 2] + arr2D[i + 1][j + 1];
                    sum = Math.max(sum, temp);
                }

                //  17.
                //  🟥
                //  🟪🟪
                //  🟪
                if ((j + 1 < xSize) && (i + 2 < ySize)) {
                    int temp = arr2D[i][j] + arr2D[i + 1][j] + arr2D[i + 1][j + 1] + arr2D[i + 2][j];
                    sum = Math.max(sum, temp);
                }

                //  18.
                //    🟪
                //  🟥🟪🟪
                //
                if ((j + 2 < xSize) && (i > 0)) {
                    int temp = arr2D[i][j] + arr2D[i][j + 1] + arr2D[i - 1][j + 1] + arr2D[i][j + 2];
                    sum = Math.max(sum, temp);
                }

                //  19.
                //    🟥
                //  🟪🟪
                //    🟪
                if ((j > 0) && (i + 2 < ySize)) {
                    int temp = arr2D[i][j] + arr2D[i+1][j] + arr2D[i + 1][j -1] + arr2D[i + 2][j];
                    sum = Math.max(sum, temp);
                }

            }
        }

        System.out.println(sum);
    }
}
