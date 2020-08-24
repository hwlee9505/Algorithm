import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[1000001];

        for (int i = 0; i < size; i++) {

            // 항상 자료형 변수 신경쓰기
            long sum = 0;
            st = new StringTokenizer(br.readLine());
            int eachSize = Integer.parseInt(st.nextToken());

            for (int j = 0; j < eachSize; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < eachSize-1; j++) {
                for (int k = j + 1; k < eachSize; k++) {
                    sum += gcd(arr[j], arr[k]);
                }
            }

            System.out.println(sum);
        }
    }

    public static int gcd(int a, int b) {

        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
