import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pair {

    int max;
    int min;

    public Pair() {
    }

    public Pair(int max, int min) {
        this.max = max;
        this.min = min;
    }
}

public class Main {

    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int mul = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());

        System.out.println(recurse(arr, 0, arr[0], plus, minus, mul, div).max);
        System.out.println(recurse(arr, 0, arr[0], plus, minus, mul, div).min);

    }

    public static Pair recurse(int[] arr, int idx, int sum, int plus, int minus, int mul, int div) {

        // 1. 정답을 찾은 경우
        if (plus == 0 && minus == 0 && mul == 0 && div == 0) {
            max = Math.max(max,sum);
            min = Math.min(min,sum);
            return new Pair(max, min);
        }

//        if (idx == arr.length - 1) {
//            max = Math.max(max,sum);
//            min = Math.min(min,sum);
//            return new Pair(max, min);
//        }
        // 2. 불가능한 경우
        
        // 3. 다음경우 호출
        Pair answer = new Pair();
        if (plus > 0) {
            answer = recurse(arr, idx + 1, sum + arr[idx + 1], plus - 1, minus, mul, div);
        }
        if (minus > 0) {
            answer = recurse(arr, idx + 1, sum - arr[idx + 1], plus, minus - 1, mul, div);
        }
        if (mul > 0) {
            answer = recurse(arr, idx + 1, sum * arr[idx + 1], plus, minus, mul - 1, div);
        }
        if (div > 0) {
            answer = recurse(arr, idx + 1, sum / arr[idx + 1], plus, minus, mul, div - 1);
        }

        return answer;
    }
}

/////////////////////////////////////////////////////////////////////////////////////////

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
