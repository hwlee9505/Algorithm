import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr = new int[10];
    public static int[] num = new int[10];
    public static int[] count = new int[10];

    public static StringBuilder recurse(int index, int n, int m) {

        // 1. 정답을 찾은 경우
        // 2. 불가능한 경우

        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(num[arr[i]] + " ");
            }
            sb.append("\n");
            return sb;
        }


        // 3. 다음 경우 호출
        StringBuilder amswer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (count[i] > 0) {
                count[i] -= 1;
                arr[index] = i;
                amswer.append(recurse(index + 1, n, m));
                count[i] += 1;
            }
        }
        return amswer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] temp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(temp);
        int idx = 0;
        int selected = temp[0];
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (selected == temp[i]) {
                cnt+= 1;
            } else {
                num[idx] = selected;
                count[idx] = cnt;
                idx += 1;
                selected = temp[i];
                cnt = 1;
            }
        }
        num[idx] = selected;
        count[idx] = cnt;

        n = idx + 1;

        System.out.println(recurse(0, n, m));
    }
}
