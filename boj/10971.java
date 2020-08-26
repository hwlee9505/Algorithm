import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    /*
     *      전체의 시간복잡도는
     *
     *      O(N * logN)이다.
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] arr2D = new int[N][N];

        for (int i = 0; i < arr2D.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr2D[0].length; j++) {
                arr2D[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int answer = Integer.MAX_VALUE;
        do {
            int sum = 0;
            int temp = 0;

            // 만약 2차원 배열 원소중 하나라도 0이 있다면
            // 이 경우의 수는 제외 해야 한다. => 이를 위한 flag
            // 변수 이름: 이런 경우의 수는 없지? (default : 아니 있어 == false)
            boolean isNonExistence = false;

            for (int i = 1; i < arr.length; i++) {

                temp = arr2D[arr[i - 1]][arr[i]];
                if (temp == 0) {
                    isNonExistence = true;
                    // 더이상 실행할 필요가 없으므로 break;
                    break;
                }
                sum += temp;
            }
            // 이경우는 루프에 빠져 나와서 한번 더 경우를 따지는 이유는
            // 이 외판원 순회 문제가 다시 시작했던 곳으로 돌아가는 경우까지 따져 줘야하기 때문이다.
            temp = arr2D[arr[arr.length - 1]][arr[0]];

            // 이런 경우는 없지 or 마지막으로 되돌아가는 경우는 없다.
            if (isNonExistence || temp == 0) {
                continue;
            }

            sum += temp;

            answer = Math.min(answer, sum);
        } while (ascendingPermutation(arr));

        System.out.println(answer);
    }

    // 다음 순열
    // C++ STL에서 next Permutation library를 직접 구현
    public static boolean ascendingPermutation(int[] arr) {

        int iIdx = arr.length - 1;
        int jIdx = arr.length - 1;

        while (iIdx > 0 && arr[iIdx - 1] >= arr[iIdx]) {
            iIdx--;
        }

        if (iIdx == 0) {
            return false;
        }

        while (jIdx >= iIdx && arr[jIdx] <= arr[iIdx - 1]) {
            jIdx--;
        }

        int temp = arr[iIdx - 1];
        arr[iIdx - 1] = arr[jIdx];
        arr[jIdx] = temp;

        jIdx = arr.length - 1;
        while (iIdx < jIdx) {

            temp = arr[iIdx];
            arr[iIdx] = arr[jIdx];
            arr[jIdx] = temp;

            iIdx++;
            jIdx--;
        }
        return true;
    }
}
