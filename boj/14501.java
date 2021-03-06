import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] time = new int[n + 1];
        int[] pay = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(recurse(time, pay, 1, 0, n));
    }

    public static int recurse(int[] time, int[] pay, int idx, int sum, int n) {

        // 2. 불가능한 경우
        if (idx > n + 1) {
            return 0;
        }

        // 1. 정답인 경우
//        if (time[idx] + idx > n + 1) {
        if (idx ==  n + 1) {
            return sum;
        }


        // 3. 다음경우 호출
        int answer = 0;
        answer = Math.max(recurse(time, pay, idx + time[idx], sum + pay[idx], n), answer);
        answer = Math.max(recurse(time, pay, idx + 1, sum, n), answer);

        return answer;
    }
}

////////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] T;          // 걸리는 기간
    public static int[] P;          // 상담을 했을 때 받을 수 있는 금액
    public static int N;            // N+1일날 퇴사
    public static int answer = 0;   // 답을 저장해 놓는 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        go(1, 0);
        System.out.println(answer);
    }

    public static void go(int day, int sum) {

        // 1. 정답인 경우 : day == n+1;
        if (day == N + 1) {
            if (answer < sum) {     // 최소인 경우를 swap
                answer = sum;
            }
            return;
        }

        // 2. 불가능한 경우
        if (day > N + 1) {
            return;
        }

        // 3. 다음 경우 호출 :
        // 1) 상담을 한다.
        go(day + T[day], sum + P[day]);

        // 2) 상담을 하지 않는다.
        go(day + 1, sum);
    }
}
