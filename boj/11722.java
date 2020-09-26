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

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        memo = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bottomUp(n);
    }

    public static void bottomUp(int n) {

        for (int i = 0; i <n; i++) {
            memo[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] < arr[j] &&  memo[i] < memo[j] + 1){
                    memo[i] = memo[j] + 1;
                }
            }
        }

        Arrays.sort(memo);
        System.out.println(memo[n-1]);
    }
} 
