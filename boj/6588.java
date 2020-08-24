import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *    골드바흐의 추측은
 *    에라토스테네스의 체를 사용하면 간편히 구할 수 있다.
 */

public class Main {
    public static final int MAX = 1000000;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] check = new boolean[MAX+1];
        ArrayList<Integer> prime = new ArrayList<Integer>();
        check[0] = check[1] = true;
        for (int i=2; i*i <= MAX; i++) {
            if (check[i]) {
                continue;
            }
            prime.add(i);
            for (int j=i*2; j<=MAX; j+=i) {
                check[j] = true;
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            for (int i=1; i<prime.size(); i++) {
                int p = prime.get(i);
                if (check[n - p] == false) {
                    System.out.println(n + " = " + p + " + " + (n-p));
                    break;
                }
            }
        }
    }
}
