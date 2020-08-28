import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// Brute Force - Recursion

public class Main {

    private static ArrayList<Integer> lotto = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {

            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());

            if (size == 0) {
                return;
            }

            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            go(arr, 0,0);
            System.out.println();

        }
    }

    public static void go(int[] arr, int idx, int cnt) {

        // 1. 정답을 찾은 경우
        if (cnt == 6) {
            for (int i : lotto) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        // 2. 불가능한 경우
        if (idx >= arr.length) {
            return;
        }

        // 3. 다음 경우 호출
        lotto.add(arr[idx]);
        go(arr, idx + 1, cnt + 1);
        lotto.remove(lotto.size()-1);
        go(arr, idx+1, cnt);
    }
}
///////////////////////////////////////////////////////////////////////////////////////////
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


            // ✨ 0과 1로 이루어진 permutation이
            // Combinatation으로 활용되도록 되었다.
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
