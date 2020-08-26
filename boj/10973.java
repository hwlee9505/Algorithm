import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (priorPermutation(arr)) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }else{
            System.out.println("-1");
        }
    }

    public static boolean priorPermutation(int[] arr) {

        int iIdx = arr.length - 1;
        int jIdx = arr.length - 1;
        while (iIdx > 0 && arr[iIdx - 1] <= arr[iIdx]) {
            iIdx--;
        }

        if (iIdx <= 0) {
            return false;
        }

        while (jIdx >= iIdx && arr[jIdx] >= arr[iIdx - 1]) {
            jIdx--;
        }

        int temp = arr[iIdx - 1];
        arr[iIdx - 1] = arr[jIdx];
        arr[jIdx] = temp;

        jIdx = arr.length -1;
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
