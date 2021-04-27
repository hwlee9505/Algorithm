package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfK {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answerList = new ArrayList<>();
        for (int[] arr : commands) {
            List<Integer> list = new ArrayList<>();
            int idx = arr[0] - 1;
            while (idx < arr[1]) {
                list.add(array[idx]);
                idx++;
            }
            Collections.sort(list);
            answerList.add(list.get(arr[2] - 1));
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = answerList.get(i);
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = new NumberOfK().solution(
                new int[]{1, 5, 2, 6, 3, 7, 4},
                new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
