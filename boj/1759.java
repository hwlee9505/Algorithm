import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
        Brute Force

        1. 재귀로
     
                n: 만들어야 하는 암호의 길이
            alpha: 사용할 수 있는 알파벳
         password: 현재까지 만든 암호
                i: 사용할지 말지 결정해야하는 알파벳 인덱스
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[] alpha = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < alpha.length; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alpha);

        go(L, alpha, "", 0);
    }

    public static void go(int n, char[] alpha, String password, int i) {

        // 2. 정답을 찾은 경우:    password의 길이 == n

        if (password.length() == n) {
            if (check(password)) {
                System.out.println(password);
            }
            return;
        }


        // 1. 불가능한 경우:      더 이상 선택해야 할지 말지 경우가 없다면
        //                    i >= alpha의 크기

        if (i >= alpha.length) {
            return;
        }

        // 3. 다음 경우 호출
        // 1) i번째 알파벳을 사용           - go(n, alpha, password + alpha[i], i+1);
        // 2) i번쨰 알파벳을 사용하지 않음     - go(n, alpha, password, i+1);
        go(n, alpha, password + alpha[i], i + 1);
        go(n, alpha, password, i + 1);

    }

    private static boolean check(String password) {
        int ja = 0;
        int mo = 0;
        for (char c : password.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                mo++;
            } else {
                ja++;
            }
        }
        return ja >= 2 && mo >= 1;
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
        Brute Force

        2. 순열로
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[] arr = new char[C];
        int[] seqArr = new int[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        rrays.sort(arr);

        int idx = 0;
        while (L-- > 0) {
            seqArr[idx++] = 1;
        }

        StringBuilder sb;
        do {
            sb = new StringBuilder();
            int vowelCnt = 0;
            int consonantCnt = 0;
            for (int i = 0; i < seqArr.length; i++) {
                if (seqArr[i] == 1) {
                    char temp = arr[i];
                    if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') {
                        vowelCnt++;
                    } else {
                        consonantCnt++;
                    }
                    sb.append(temp);
                }
            }
            String temp = sb.toString();
            if (temp.length() < 3 || vowelCnt < 1 || consonantCnt < 2) {
                continue;
            }
            System.out.println(sb.toString());
        } while (priorPermutation(seqArr));
    }

    public static boolean priorPermutation(int[] arr) {

        int iIdx = arr.length - 1;
        int jIdx = arr.length - 1;

        while (iIdx > 0 && arr[iIdx - 1] <= arr[iIdx]) {
            iIdx--;
        }

        if (iIdx == 0) {
            return false;
        }

        while (jIdx >= iIdx && arr[jIdx] >= arr[iIdx - 1]) {
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
