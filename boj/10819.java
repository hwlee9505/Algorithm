import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 *      O(N * N!)인데
 *      CPU는 1초에 1억가량 수행 조건을 따져봤을때
 *
 *      (3 <= N <= 8)을 따져 봤을 떄, 모든 경우의 수를 따져봐도 시간초과에 걸리지 않는다.
 *
 *      ✨✨ 그럼 어떤 로직으로 접근 할껀데?
 * 
 *      이전과 마찬가지로 Next Permutation을 이용해 모든 경우의 수를 구해야지
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        Arrays.sort(arr);
        do {
            int sum = 0;
            for (int i = 1; i < arr.length; i++) {
                sum += Math.abs(arr[i-1] - arr[i]);
            }
            answer = Math.max(answer, sum);
        } while (ascendingPermutation(arr));

        System.out.println(answer);
    }


    public static boolean ascendingPermutation(int[] arr) {

        int iIdx = arr.length - 1;
        int jIdx = arr.length - 1;

        while (iIdx > 0 && arr[iIdx - 1] >= arr[iIdx]) {
            iIdx--;
        }

        if (iIdx == 0) {
            return false;
        }

        while (iIdx <= jIdx && arr[jIdx] <= arr[iIdx - 1]) {
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
