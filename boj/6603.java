import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {

            st = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(st.nextToken());

            // 0이 들어오면 Exit!!
            if (K == 0) {
                return;
            }
            
            // arr은 K개의 원소들을 담은 배열
            int[] arr = new int[K];

            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 있고 없고 따지는 경우의 수 배열
            int[] boolChecked = new int[K];

            int cnt = 0;
            while (cnt < 6) {
                boolChecked[cnt++] = 1;
            }


            do {
                for (int i = 0; i < boolChecked.length; i++) {
                    if (boolChecked[i] == 1) {
                        System.out.print(arr[i] + " ");
                    } else {
                        continue;
                    }
                }
                System.out.println();
            } while (prevPermutation(boolChecked));

            System.out.println();
        }
    }

    // 이전 순열을 사용
    public static boolean prevPermutation(int[] arr) {

        int iIdx = arr.length - 1;
        int jIdx = arr.length - 1;

        while (iIdx > 0 && arr[iIdx - 1] <= arr[iIdx]) {
            iIdx--;
        }

        if (iIdx == 0) {
            return false;
        }

        while (jIdx >= iIdx && arr[jIdx] >= arr[iIdx - 1]) {
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
