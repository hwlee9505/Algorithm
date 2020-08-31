import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pair {
    public int max;
    public int min;

    public Pair(int max, int min) {
        this.max = max;
        this.min = min;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

       st = new StringTokenizer(br.readLine());

        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int mul = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());

        Pair answer = recurse(arr, 1, arr[0], plus, minus, mul, div);
        System.out.println(answer.max);
        System.out.println(answer.min);

    }

    public static Pair recurse(int[] arr, int idx, int sum, int plus, int minus, int mul, int div) {

        // 1. 정답을 찾은 경우
        if (idx == arr.length) {
            return new Pair(sum, sum);
        }

        // 2. 불가능한 경우 (없어도 됌)
        if (plus == 0 && minus == 0 && mul == 0 && div == 0) {
            return null;
        }

        List<Pair> result = new ArrayList<>();

        // 3. 다음 경우 호출
        if (plus > 0) {
            result.add(recurse(arr, idx + 1, sum + arr[idx], plus - 1, minus, mul, div));
        }
        if (minus > 0) {
            result.add(recurse(arr, idx + 1, sum - arr[idx], plus, minus - 1, mul, div));
        }
        if (mul > 0) {
            result.add(recurse(arr, idx + 1, sum * arr[idx], plus, minus, mul - 1, div));
        }
        if (div > 0) {
            result.add(recurse(arr, idx + 1, sum / arr[idx], plus, minus, mul, div - 1));
        }

        Pair answer = result.get(0);

        for (Pair pair : result) {
            if (answer.max < pair.max) {
                answer.max = pair.max;
            }
            if (answer.min > pair.min) {
                answer.min = pair.min;
            }
        }
        return answer;
    }
} 
