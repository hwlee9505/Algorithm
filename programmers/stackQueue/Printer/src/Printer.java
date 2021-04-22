import java.util.*;

public class Printer {

    public int getPrintOrder(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.stream(priorities).forEach(i -> queue.offer(i));
        Integer[] sortedArr = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedArr, Collections.reverseOrder());
        int idx = 0;
        int answer = 1;
        while (!queue.isEmpty()) {
            if (sortedArr[idx] != queue.peek()) {
                queue.offer(queue.poll());
                if (location == 0)
                    location = queue.size() -1;
                else
                    location--;
                continue;
            }
            if (location == 0 && sortedArr[idx] == queue.peek())
                return (answer);
            queue.poll();
            if (location == 0)
                location = queue.size() -1;
            else
                location--;
            answer++;
            idx++;
        }
        return (answer);
    }
}
