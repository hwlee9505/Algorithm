import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//--------------------------------------------------------------------------------------------
// Dynamic Programming [Overlapping SubProblem, Optimal Substructure]
//--------------------------------------------------------------------------------------------
// 1. Top Down
//      1) 점화식 구하기
//      2) 문제 -> 작은 문제
//
// D[N] = 정수 N을 1,2,3의 합으로 나타내는 방법의 수를 구하는 문제(단, 같은 수를 두 번 이상 연속해서 사용하면 안 된다.)
//--------------------------------------------------------------------------------------------
// D[i][j] = i를 1,2,3의 합으로 나타내는 방법의 수, 마지막에 사용한 수는 j
//
// 1. D[i][1] = i를 1,2,3의 합으로 나타내는 방법의 수, 마지막에 사용한 수는 1
//    바로 전에 사용할 수 있는 수는 2,3
//    D[i][1] = D[i-1][2] + D[i-1][3]
//
// 2. D[i][j] = i를 1,2,3의 합으로 나타내는 방법의 수, 마지막에 사용한 수는 2
//    바로 전에 사용할 수 있는 수는 1,3
//    D[i][2] = D[i-1][1] + D[i-1][3]
//
// 3. D[i][3] = i를 1,2,3의 합으로 나타내는 방법의 수, 마지막에 사용한 수는 3
//    바로 전에 사용할 수 있는 수는 1,2
//    D[i][3] = D[i-1][1] + D[i-1][2]
//--------------------------------------------------------------------------------------------

public class Main {
    public static long[][] memo ;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            
            int temp = Integer.parseInt(br.readLine());
            
            // Bottom Up
            memo = new long[100001][4];
            System.out.println(bottomUp(temp));
        }
    }

    // Top Down - 어렵다..

    // Bottom Up
    public static long bottomUp(int n) {

        // Init
        // 1을 만드는데 1을 사용하는 경우의 수는 1
        // 2를 만드는데 2를 사용하는 경우의 수는 1
        // 3을 만드는데 3을 사용하는 경우의 수는 1
        memo[1][1] = memo[2][2] = memo[3][3] = 1;

        for (int i = 1; i < memo.length; i++) {
            if (i > 1) memo[i][1] = (memo[i - 1][2] + memo[i - 1][3]) % 1000000009;
            if (i > 2) memo[i][2] = (memo[i - 2][1] + memo[i - 2][3]) % 1000000009;
            if (i > 3) memo[i][3] = (memo[i - 3][1] + memo[i - 3][2]) % 1000000009;
        }

        // 맨 마지막 경우의 수를 더해주는 연산을 할 때도 나눠 주어야 한다.
        return (memo[n][1] + memo[n][2] + memo[n][3]) % 1000000009;
    }
}
