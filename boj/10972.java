import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /**
     * --------------------------- 예시 ------------------------------
     *      
     *      1 | 7 6 5 4 3 2 (마지막)    iIdx = 1, iIdx-1 = 0, jIdx = 6
     *                                swap(iIdx-1, jIdx)
     *
     *      2 | 7 6 5 4 3 1           여기서 순열을 뒤집는다.
     *
     *      2 | 1 2 3 4 5 6 (첫 순열)
     *
     * --------------------------------------------------------------
     * 
     * 1. A[i-1] < A[i]를 만족하는 가장 큰 i를 찾는다.             => O(N)
     * 2. j >= i 이면서 A[j] > A[i-1]를 만족하는 가장 큰j를 찾는다.  => O(N)
     * 3. A[i-1]과 A[j]를 swap한다.                           => O(1)
     * 4. A[i]부터 순열을 뒤집는다.                              => O(N)
     *
     * 1,2,3,4는 독립적으로 수행 되므로
     * 전체 시간복잡도는 O(N)이다.
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int iIndex = -1;
        int jIndex = 0;

        // 1. A[i-1] < A[i]를 만족하는 가장 큰 i를 찾는다.             => O(N)
        for (int i = 1; i < arr.length; i++) {

            if (arr[i - 1] < arr[i]) {
                iIndex = i;
            }
        }
        // 예외 처리) 내림차순인 마지막 순열일 경우 -1을 출력하고 종료 시킨다.
        if (iIndex == -1) {
            System.out.println(iIndex);
            return;
        }

        // 2. j >= i 이면서 A[j] > A[i-1]를 만족하는 가장 큰j를 찾는다.  => O(N)
        for (int i = 1; i < arr.length; i++) {
            if (i >= iIndex && arr[i] > arr[iIndex - 1]) {
                jIndex = i;
            }
        }

        // 3. A[i-1]과 A[j]를 swap한다.                           => O(1)
        int temp = arr[iIndex - 1];
        arr[iIndex - 1] = arr[jIndex];
        arr[jIndex] = temp;


        // 4. A[i]부터 순열을 뒤집는다.                              => O(N)
        for (int i = 0; i < iIndex; i++) {
            System.out.print(arr[i] + " ");
        }
        for (int i = arr.length - 1; i >= iIndex; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
