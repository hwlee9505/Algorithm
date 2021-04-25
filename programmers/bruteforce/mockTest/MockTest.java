package bruteforce;

import java.util.ArrayList;
import java.util.List;

class Run {
    public static void main(String[] args) {
        int[] arr = new MockTest().solution(new int[]{1, 3, 2, 4, 2});
        for (int i : arr)
            System.out.print(i + " ");
    }
}

public class MockTest {

    public int[] solution(int[] answers) {
        int[] first = new int[]{1, 2, 3, 4, 5};
        int[] second = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] eachAnswer = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % first.length])
                eachAnswer[0]++;
            if (answers[i] == second[i % first.length])
                eachAnswer[1]++;
            if (answers[i] == third[i % first.length])
                eachAnswer[2]++;
        }
        List<Integer> list = new ArrayList<>();
        int max = eachAnswer[0];
        max = Math.max(Math.max(max, eachAnswer[1]), eachAnswer[2]);
        for (int i = 0; i < eachAnswer.length; i++) {
            if (max == eachAnswer[i])
                list.add(i + 1);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = list.get(i);
        return (answer);
    }
}
