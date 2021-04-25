package navigation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Run {
    public static void main(String[] args) {
//        String[] str1 = new TravelRoute().solution(new String[][]{
//                {"ICN", "JFK"},
//                {"HND", "IAD"},
//                {"JFK", "HND"}
//        });

        String[] str2 = new TravelRoute().solution(new String[][]{
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
        });
//        for (String s : str1) {
//            System.out.print(s + " ");
//        }
        for (String s : str2) {
            System.out.print(s + " ");
        }
    }
}

public class TravelRoute {

    boolean[] check;
    List<String> answers;

    public String[] solution(String[][] tickets) {
        check = new boolean[tickets.length];
        answers = new ArrayList<>();
        int cnt = 0;
        DFS(cnt, "ICN", "ICN", tickets);
        Collections.sort(answers);
        String[] answer = answers.get(0).split(" ");
        return (answer);
    }

    /**
     *
     * 미췄다 문제가 나에겐 신세계다! check를 ticket[][]하나의 원소가 아닌 ticket[]로 보자
     *
     * @param depth
     * @param present
     * @param answer 👍backtraking을 하면서 문자열을 덧 붙여주자.
     * @param tickets
     */
    public void DFS(int depth, String present, String answer, String[][] tickets) {
        if (depth == tickets.length) {
            answers.add(answer);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!check[i] && tickets[i][0].equals(present)) {
                check[i] = true;
                DFS(depth + 1, tickets[i][1], answer + " " + tickets[i][1], tickets);
                check[i] = false;
            }
        }
    }
}
