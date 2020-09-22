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

// 점화식 경우를 왜인지 생각해봐
// D[N] = D[N-1] + D[N-2] + D[N-3]

public class Main {

    public static int[] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            int temp = Integer.parseInt(br.readLine());

            // 1. top down
            memo = new int[temp + 1];
            System.out.println(topDown(temp));

            // 2. bottom up
            memo = new int[temp +1];
            System.out.println(bottomUp(temp));

        }
    }

    public static int topDown(int n) {

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
            memo[n] = topDown(n - 1) + topDown(n - 2) + topDown(n - 3);
        }
        return memo[n];
    }

    public static int bottomUp(int n) {

        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 2;

        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
        }
        return memo[n];
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            int goal = Integer.parseInt(br.readLine());
            cnt = 0;
            recurse(0, goal);
            System.out.println(cnt);
        }
    }

    public static void recurse(int sum, int goal) {

        // 1. 정답일 경우
        if (sum == goal) {
            ++cnt;
            return;
        }

        // 2. 불가능할 경우
        if (sum > goal) {
            return;
        }

        // 3. 다음 경우 호출
        for (int i = 1; i <= 3; i++) {
            recurse(sum + i, goal);
        }
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            System.out.println(go(0,arr[i]));
        }
    }

    public static int go(int sum, int goal) {

        // 1.불가능한 경우
        if (sum > goal) return 0;

        // 2.정답을 찾은 경우
        if (sum == goal) return 1;

        // 3.다음 경우 호출
        int now = 0;

        for(int i = 1 ; i <= 3; i++ ){
            now += go( sum +i, goal);
        }
        return now;
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            int answer = 0;

            int n = Integer.parseInt(br.readLine());

            for (int l1 = 1; l1 <= 3; l1++) {
                if (l1 == n) {
                    answer++;
                }
                for (int l2 = 1; l2 <= 3; l2++) {
                    if (l1 + l2 == n) {
                        answer++;
                    }

                    for (int l3 = 1; l3 <= 3; l3++) {
                        if (l1 + l2 + l3 == n) {
                            answer++;
                        }

                        for (int l4 = 1; l4 <= 3; l4++) {
                            if (l1 + l2 + l3 + l4 == n) {
                                answer++;
                            }

                            for (int l5 = 1; l5 <= 3; l5++) {
                                if (l1 + l2 + l3 + l4 + l5 == n) {
                                    answer++;
                                }


                                for (int l6 = 1; l6 <= 3; l6++) {
                                    if (l1 + l2 + l3 + l4 + l5 + l6 == n) {
                                        answer++;
                                    }


                                    for (int l7 = 1; l7 <= 3; l7++) {
                                        if (l1 + l2 + l3 + l4 + l5 + l6 + l7 == n) {
                                            answer++;
                                        }


                                        for (int l8 = 1; l8 <= 3; l8++) {
                                            if (l1 + l2 + l3 + l4 + l5 + l6 + l7 + l8 == n) {
                                                answer++;
                                            }


                                            for (int l9 = 1; l9 <= 3; l9++) {
                                                if (l1 + l2 + l3 + l4 + l5 + l6 + l7 + l8 + l9 == n) {
                                                    answer++;
                                                }


                                                for (int l0 = 1; l0 <= 3; l0++) {
                                                    if (l1 + l2 + l3 + l4 + l5 + l6 + l7 + l8 + l9 + l0 == n) {
                                                        answer++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
