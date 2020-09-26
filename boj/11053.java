import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;
    public static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        memo = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bottomUp(n));
    }

    public static int bottomUp(int n) {

        for (int i = 0; i < n; i++) {
            // memo[i]는 arr[i]를 반드시 포함되어야한다. (최소 자신을 포함하는 1가지 경우가 있기 떄문에)
            memo[i] = 1;
            for(int j = 0; j < i; j ++){
                // 나보다 작은 수여야 함 && 왼쪽부터 큰거를 넣는데 현재보다 작은경우는 넣을 필요가 없다.
                if(arr[j] < arr[i] && memo[i] < memo[j] +1){
                    memo[i] = memo[j] + 1;
                }
            }
        }

        Arrays.sort(memo);
        return memo[n-1];
    }
}
