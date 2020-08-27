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
