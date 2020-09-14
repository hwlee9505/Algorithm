import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr = new int[10];
    public static int[] num = new int[10];
    public static int[] check = new int[10];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] temp = new int[9];
        for (int i = 0; i < n; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(temp, 0, n);

        int idx = 0;
        int selected = temp[0];
        int cnt = 1;

        for (int i = 1; i <= n; i++) {
            if (selected == temp[i]) {
                cnt++;
                continue;
            }
            check[idx] = cnt;
            num[idx] = selected;
            selected = temp[i];
            idx++;
            cnt = 1;
        }
        n = idx;

        System.out.println(recurse(0, n, m));
    }

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
            if (check[i] > 0) {
                check[i] -= 1;
                arr[index] = i;
                amswer.append(recurse(index + 1, n, m));
                check[i] += 1;
            }
        }
        return amswer;
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Result implements Comparable<Result> {

    Integer[] arr;

    public Result(List<Integer> list) {
        this.arr = list.toArray(new Integer[list.size()]);
    }

    public int get(int index) {
        return this.arr[index];
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Result) {
            Result that = (Result) o;
            int n = this.arr.length;
            for (int i = 0; i < n; i++) {
                if (this.arr[i] != that.arr[i]) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Result that) {
        int n = this.arr.length;
        for (int i = 0; i < n; i++) {
            if (this.arr[i] == that.arr[i]) {
                continue;
            }
            if (this.arr[i] < that.arr[i]) {
                return -1;
            }
            if (this.arr[i] > that.arr[i]) {
                return 1;
            }
        }
        return 0;
    }
}

public class Main {

    public static boolean[] check = new boolean[9];
    public static int[] arr = new int[9];
    public static int[] num = new int[9];
    public static List<Result> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num, 0, n);

        recurse(0, n, m);

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            if (i == 0 || !list.get(i).equals(list.get(i - 1))) {
                for (int j = 0; j < m; j++) {
                    sb.append(list.get(i).get(j));
                    if (j != m - 1) {
                        sb.append(" ");
                    }
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void recurse(int idx, int n, int m) {

        // 1. 정답인 경우
        // 2. 불가능한 경우
        if (idx == m) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                temp.add(num[arr[i]]);
            }
            list.add(new Result(temp));
            return;
        }

        // 3. 다음 경우 호출
        for (int i = 0; i < n; i++) {
            if (check[i]) {
                continue;
            }
            check[i] = true;
            arr[idx] = i;
            recurse(idx + 1, n, m);
            check[i] = false;
        }
    }
}
