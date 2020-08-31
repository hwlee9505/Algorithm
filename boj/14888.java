import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair {
    public int min, max;

    Pair(int min, int max) {
        this.min = min;
        this.max = max;
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

        Pair ans = calc(arr, 1, arr[0], plus, minus, mul, div);
        System.out.println(ans.max);
        System.out.println(ans.min);
    }

    static Pair calc(int[] a, int index, int cur, int plus, int minus, int mul, int div) {
        int n = a.length;

        if (index == n) {
            return new Pair(cur, cur);
        }

        ArrayList<Pair> res = new ArrayList<>();

        if (plus > 0) {
            res.add(calc(a, index + 1, cur + a[index], plus - 1, minus, mul, div));
        }
        if (minus > 0) {
            res.add(calc(a, index + 1, cur - a[index], plus, minus - 1, mul, div));
        }
        if (mul > 0) {
            res.add(calc(a, index + 1, cur * a[index], plus, minus, mul - 1, div));
        }
        if (div > 0) {
            res.add(calc(a, index + 1, cur / a[index], plus, minus, mul, div - 1));
        }


        // 가장 큰 작은 것을 추리는 로직
        Pair ans = res.get(0);

        for (Pair p : res) {
            if (ans.max < p.max) {
                ans.max = p.max;
            }
            if (ans.min > p.min) {
                ans.min = p.min;
            }
        }
        return ans;
    }
}

/////////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] operation = new int[4];

        for (int i = 0; i < operation.length; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }

        int[] operationArr = new int[size - 1];

        int operIdx = 0;
        while(operation[0]-- >0){
            operationArr[operIdx++] = 0;
        }
        while(operation[1]-- >0){
            operationArr[operIdx++] = 1;
        }
        while(operation[2]-- >0){
            operationArr[operIdx++] = 2;
        }
        while(operation[3]-- >0){
            operationArr[operIdx++] = 3;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        do {

            int sum = arr[0];
            for (int i = 0; i < arr.length-1; i++) {

                if(operationArr[i] == 0){
                    sum += arr[i+1];
                }else if(operationArr[i] == 1){
                    sum -= arr[i+1];
                }else if(operationArr[i] == 2){
                    sum *= arr[i+1];
                }else if(operationArr[i] == 3){
                    sum /= arr[i+1];
                }
            }
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        } while (nextPermutation(operationArr));

        System.out.println(max);
        System.out.println(min);

    }

    public static boolean nextPermutation(int[] arr) {

        int iIdx = arr.length - 1;
        int jIdx = arr.length - 1;

        while (iIdx > 0 && arr[iIdx - 1] >= arr[iIdx]) {
            iIdx--;
        }

        if (iIdx == 0) {
            return false;
        }

        while (jIdx >= iIdx && arr[jIdx] <= arr[iIdx - 1]) {
            jIdx--;
        }

        int temp = arr[iIdx - 1];
        arr[iIdx - 1] = arr[jIdx];
        arr[jIdx] = temp;

        jIdx = arr.length - 1;

        while (iIdx < jIdx) {
            temp = arr[iIdx];
            arr[iIdx] = arr[jIdx];
            arr[jIdx] = temp;

            iIdx++;
            jIdx--;
        }
        return true;
    }
}
