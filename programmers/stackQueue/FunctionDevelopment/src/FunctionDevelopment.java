import java.util.*;

public class FunctionDevelopment {

    /**
     *
     * @param progresses 완료된 %
     * @param speeds    각 작업의 개발 속도
     * @return  각 배포마다 몇 개의 기능이 배포되는지
     */
    public  int[] getEachDistribution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0 ; i < progresses.length; i++) {
            int takeTimes =
                    ((100 - progresses[i]) % speeds[i] != 0 ?
                            (100 - progresses[i]) / speeds[i] + 1:
                            (100 - progresses[i]) / speeds[i]);
            queue.offer(takeTimes);
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            int cnt = 1;
            while (!queue.isEmpty() && temp >= queue.peek()) {
                queue.poll();
                ++cnt;
            }
            list.add(cnt);
        }
        return (list.stream().mapToInt(i -> i).toArray());
    }

    static class Run {
        public static void main(String[] args) {
//            new FunctionDevelopment().getEachDistribution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
            int[] result = new FunctionDevelopment().getEachDistribution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
            Arrays.stream(result).forEach(i -> System.out.print(i + " "));
        }
    }
}
