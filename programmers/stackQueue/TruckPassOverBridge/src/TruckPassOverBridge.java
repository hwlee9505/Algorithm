import java.util.LinkedList;
import java.util.Queue;

public class TruckPassOverBridge {
    /**
     * [Programmers 다리위를 지나는 트럭]
     * 문제유형: Queue 자료구조
     *
     * 대기 큐와 다리위 큐가 모두 isEmpty 일 때 그때의 시간을 반환해주자
     *
     * @param bridge_length 다리의 길이 (1 <= n <= 10,000)
     * @param weight        다리가 버티는 무게 (1 <= n < 10,000)
     * @param truck_weights 트럭별 무게 (1 <= n < 10,000)
     * @return 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지
     */
    public int getTakenTime(int bridge_length, int weight, int[] truck_weights) {
        int nowTime = 0;
        int totalWeight = 0;

        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int i : truck_weights)
            waitQ.offer(new Truck(i));

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            nowTime++;

            /**
             * case1) 다리위에 아무 트럭이 없을때
             */
            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                totalWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            /**
             * case2) 다리위에 트럭이 있을 때
             */
            for (Truck t : moveQ) {
                t.moving();
            }

            /**
             * 다리위 트럭이 다리길이를 넘어 섰을때
             */
            if (moveQ.peek().move > bridge_length) {
                Truck t = moveQ.poll();
                totalWeight -= t.weight;
            }

            /**
             * 다리가 다음에 들어올 트럭의 무게를 버틸 수 있다면
             */
            if(!waitQ.isEmpty() && (totalWeight + waitQ.peek().weight <= weight)){
                Truck t = waitQ.poll();
                totalWeight += t.weight;
                moveQ.offer(t);
            }
        }
        return (nowTime);
    }
    static class Truck {
        int weight;
        int move;

        Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        void moving() {
            this.move++;
        }
    }
}
