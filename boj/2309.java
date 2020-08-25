import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                int sum = 0;

// 내가 짠 코드                
                for (int h : arr) {
                    if (h != arr[i] && h != arr[j])
                        sum += h;
                }

                if (sum == 100) {
                    for (int h : arr) {
                        if (h != arr[i] && h != arr[j])
                            System.out.println(h);
                    }
                    return; //  조합의 경우가 여러가지 일 수 있으므로
                    //  원하는 조건이 갖춰 졌다면 종료시켜야 한다.
                }

// 더 간결한 코드                
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
