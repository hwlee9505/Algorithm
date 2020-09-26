import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;
    public static int[] memo;

    public static int[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        memo = new int[n];

        v = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bottomUp(n);
    }

    public static void bottomUp(int n) {

        for (int i = 0; i < n; i++) {
            memo[i] = 1;
            v[i] = -1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && memo[i] < memo[j] + 1) {
                    memo[i] = memo[j] + 1;
                    v[i] = j;
                }
            }
        }

        int answer = memo[0];
        int p = 0;
        for (int i=0; i<n; i++) {
            if (answer < memo[i]) {
                answer = memo[i];
                p = i;
            }
        }
        System.out.println(answer);

        go(p);
    }

    public static void go(int p){
        if(p == -1) return;
        go(v[p]);
        System.out.print(arr[p] + " ");
    }
}
