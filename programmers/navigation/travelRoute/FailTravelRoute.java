package navigation;

import java.util.*;

public class FailTravelRoute {
    /**
     * BFS로 풀 것이고 각 노드들은 문자열이므로 map을 이용하여 번호를 달아 줄 것이다.
     * ("ICN",1) 2 3 4.. 이런식으로
     * 모든 비행기 표를 써야하는게 핵심이고 모든 비행기 표를 다쓰는 경우가 2이상일 경우 알파벳순으로 => 인접행렬 정렬하면 된다.
	 *
     * @param tickets 편도행 티켓
     * @return 주어진 모든 도시를 방문하는 경로
     */
    public String[] solution(String[][] tickets) {
        Map<String, Integer> map = new HashMap<>();
        int nodeIdx = 1;
        for (int i = 0; i < tickets.length; i++) {
            if (!map.containsKey(tickets[i][0])) {
                map.put(tickets[i][0], nodeIdx++);
            }
            if (!map.containsKey(tickets[i][1])) {
                map.put(tickets[i][1], nodeIdx++);
            }
        }

        map.forEach((k, v) -> System.out.print(" k: " + k + " v: " + v +"\n"));
        System.out.println();

        ArrayList<Integer>[] list = new ArrayList[tickets.length + 2];
        for (int i = 0; i < list.length; i++)
            list[i] = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++)
            list[map.get(tickets[i][0])].add(map.get(tickets[i][1]));
        for (int i = 0; i < tickets.length; i++)
            Collections.sort(list[i]);
        boolean[] check = new boolean[tickets.length + 2];
        List<String> answerList = new ArrayList<>();
        BFS(1, list, check, answerList, map);
        return (answerList.toArray(new String[answerList.size()]));
    }

    public void BFS(int start, ArrayList<Integer>[] list, boolean[] check, List<String> answerList, Map<String, Integer> map) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        check[start] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            map.forEach((k, v) -> {
                if (temp == v) {
                    answerList.add(k);
                }
            });
            for (int i : list[temp]) {
                if (!check[i]) {
                    check[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
