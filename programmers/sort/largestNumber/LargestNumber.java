package sort;

import java.util.*;
import java.util.stream.Collectors;

public class LargestNumber {
    List<String> list = new ArrayList<>();
    public String solution(int[] numbers) {

        /**
         * DFS시 (메모리 초과, 시간 초과) 더 효율적인 알고리즘을 짜야한다.
         */
//        boolean[] check = new boolean[numbers.length];
//        DFS(0, "", numbers, check);
//        Collections.sort(list, Comparator.reverseOrder());
//        return list.get(0);
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i : numbers)
            list.add(i + "");
        Collections.sort(list, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        list.forEach(i -> sb.append(i));
        if (sb.toString().charAt(0) == '0')
            return "0";
        return sb.toString();
    }

    public void DFS(int depth, String temp, int[] numbers, boolean[] check) {
        if (depth == numbers.length) {
            list.add(temp);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (!check[i]) {
                check[i] = true;
                DFS(depth + 1, temp + numbers[i], numbers, check);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LargestNumber().solution(new int[]{0, 0}));
    }
}
