import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = go(arr, S, 0, 0);

        // 공집합인 경우를 처리하는 부분
        if (S == 0) {
            answer--;
        }
        System.out.println(answer);

    }

    public static int go(int[] arr, int S, int idx, int sum) {

        if (idx == arr.length) {
            if (sum == S) {            // 1.정답을 찾은 경우
                return 1;
            } else {                   // 2.불가능한 경우
                return 0;
            }
        }
        return go(arr, S, idx + 1, sum + arr[idx]) + go(arr, S, idx + 1, sum);
    }
}
