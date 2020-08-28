import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
        Brute Force

        2. 순열로
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[] arr = new char[C];
        int[] seqArr = new int[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        rrays.sort(arr);

        int idx = 0;
        while (L-- > 0) {
            seqArr[idx++] = 1;
        }

        StringBuilder sb;
        do {
            sb = new StringBuilder();
            int vowelCnt = 0;
            int consonantCnt = 0;
            for (int i = 0; i < seqArr.length; i++) {
                if (seqArr[i] == 1) {
                    char temp = arr[i];
                    if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') {
                        vowelCnt++;
                    } else {
                        consonantCnt++;
                    }
                    sb.append(temp);
                }
            }
            String temp = sb.toString();
            if (temp.length() < 3 || vowelCnt < 1 || consonantCnt < 2) {
                continue;
            }
            System.out.println(sb.toString());
        } while (priorPermutation(seqArr));
    }

    public static boolean priorPermutation(int[] arr) {

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
