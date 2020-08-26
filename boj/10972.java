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
        //
        //
        // 이걸 놓쳤는데 서로 양끝에서 부터 swap을 해줬으면 됬는데
        //
        // 이렇게 안한
        // 허접한 코드이다.
        for (int i = 0; i < iIndex; i++) {
            System.out.print(arr[i] + " ");
        }
        for (int i = arr.length - 1; i >= iIndex; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}

/////////////////////////////////////////////////////////////////////////
////////////////////////////////2번째 방법/////////////////////////////////
/////////////////////////////////////////////////////////////////////////

import java.util.*;

public class Main {
    public static boolean next_permutation(int[] a) {
        int i = a.length-1;

        // 거꾸로 탐색 하면서 => 그 이유는 index가 가장 큰 것중에서 찾는 것이기 때문에
        // a[i-1] < a[i] 중 i가 가장 큰 것을 찾아야한다.
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        // 내림차순일 경우 false를 리턴 한다.
        if (i <= 0) {
            return false;
        }

        // 거꿀로 탐색 하면서 => 그 이유도 마찬가지로 idx가 가장 큰 것중에서 찾는 것이기 때문에
        // j >= i && a[j] > a[i-1] 이어야 한다.
        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        // swap 해주고
        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;
        // (i~j 까지) 서로 양끝에 있는 idx를 swap하면 O(N)인데 이걸 생각 못했다.
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        if (next_permutation(a)) {
            for (int i=0; i<n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("-1");
        }
    }
}
