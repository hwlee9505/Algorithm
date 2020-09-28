import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//----------------------------------------------------------
// Dynamic Programming, LIS(Longest Increasing SubSequence)
//----------------------------------------------------------
//
// 1. 점화식 세우기
// D[i] = i번째 수로 끝나는 가장 큰 연속합
//
// i번째 수에게 가능한 경우
// 1. i-1번째 수의 연속합에 포함되는 경우
//    D[i-1] + A[i]
// 2. 새로운 연속합을 시작하는 경우
//    A[i]
//
// 1과 2 두 값 중에 어떤 값이 D[i]에 들어가야 할까? (최대값)
// D[i] = max(D[i-1] + A[i], A[i])
//----------------------------------------------------------
public class Main {

    public static int[] arr;
    public static int[] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        memo = new int[n];
        bottomUp(n);
    }

    public static void bottomUp(int n) {

        for (int i = 0; i < n; i++) {
            memo[i] = arr[i];
            if (i == 0) continue;
            if (memo[i] < memo[i - 1] + arr[i]) {
                memo[i] = memo[i - 1] + arr[i];
            }
        }

        // 전 문제에서 최댓값을 찾는데에 Arrays.sort를 쓴적이 있는데
        // 그러면 O(N*logN)으로서 더 걸립니다.
        int answer = memo[0];
        for (int i = 0; i < n; i++) {
            if (answer < memo[i]) {
                answer = memo[i];
            }
        }
        System.out.println(answer);
    }
}
