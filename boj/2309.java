import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *      Brute Force 3 단계
 *
 *      1. 문제의 가능한 경우의 수를 계산해본다. (손으로, Permutation or Combination)
 *
 *      nC2 (9명중 7명을 뽑는 것은 반대로, 9명중 2명을 뽑아내는 것과 동일하다.)
 *      => O( n * (n-1) / 2)  ==  O(N^2)
 *
 *      2. 가능한 모든 방법을 다 만들어 본다. (하나도 빠짐없어야 한다.)
 *      3. 각각의 방법을 이용해 답을 구해본다.
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        // 2.이곳 이중 루프가 모든 경우의 수이다. (Combination)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                int sum = 0;

// 내가 짠 코드 => O(N^3)
                for (int h : arr) {
                    if (h != arr[i] && h != arr[j])
                        sum += h;
                }

                // 3. 이곳 분기문에 의한 sysout이 방법을 통해 답을 구하는 과정이다.
                if (sum == 100) {
                    for (int h : arr) {
                        if (h != arr[i] && h != arr[j])
                            System.out.println(h);
                    }
                    return; //  조합의 경우가 여러가지 일 수 있으므로
                    //  원하는 조건이 갖춰 졌다면 종료시켜야 한다.
                }

// 더 간결한 코드 => O(N^2) [사전에 sum을 배열 원소의 총합을 가지고 있어야 한다.]
//                if (sum - arr[i] - arr[j] == 100) {
//                    for (int k = 0; k < arr.length; k++) {
//                        if (i == k || j == k) continue;
//                        System.out.println(arr[k]);
//                    }
//                    System.exit(0);
//                }
//
            }
        }
    }
} 
