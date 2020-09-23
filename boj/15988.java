import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Dynamic Programming [Overlapping SubProblem(부분 문제가 겹친다), Optimal Substructure(문제의 정답을 작은 문제의 정답에서 찾을 수 있다)]
// 1. Top Down
//      1) 점화식 구하기
//      2) 문제 -> 작은 문제
//
// DP는 최적의 경우를 알아내기 위해 사용한다 들었는데 이 문제를 DP로?
//
// D[N] = 정수 N을 1,2,3의 합으로 나타내는 방법의 수를 구하는 문제

// D[N] = D[N-1] + D[N-2] + D[N-3]

// 이 문제에서 배운 팁 두 가지
// 1. 숫자가 커서 나누기를 답으로 하는 문제들은 대부분 long 자료형을 사용해야한다.  
// 2. 공집합도 1로 보는 일반화

public class Main {

    public static long[] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            int temp = Integer.parseInt(br.readLine());

            // 1. top down
            memo = new long[1000001];
            System.out.println(topDown(temp));

            // 2. bottom up
            memo = new long[1000001];
            System.out.println(bottomUp(temp));

        }
    }
    public static long topDown(int n) {

        // 0만드는 경우는
        // 아무것도 선택하지 않은 경우 == 1
        // 공집합도 1로 일반화 해주면 좋다.
        if (n == 0 || n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            if (memo[n] > 0) {
                return memo[n];
            }
            memo[n] = (topDown(n - 1) + topDown(n - 2) + topDown(n - 3)) % 1000000009;
        }
        return memo[n];
    }

    public static long bottomUp(int n) {

        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 2;

        for (int i = 3; i <= 1000000; i++) {
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
            memo[i] %= 1000000009;
        }
        return memo[n];
    }
}

