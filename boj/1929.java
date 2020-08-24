import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[m+1];
        check[0] = check[1] = true;
        for (int i=2; i*i <= m; i++) {
            if (check[i] == true) {
                continue;
            }
            for (int j=i+i; j<=m; j+=i) {
                check[j] = true;
            }
        }
        for (int i=n; i<=m; i++) {
            if (check[i] == false) {
                System.out.println(i);
            }
        }
    }
}
