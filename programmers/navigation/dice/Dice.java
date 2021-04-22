package navigation;

/**
 * [DFS를 알기 위해 가장 기초적인 문제]
 * 10이하의 자연수 N을 입력받아 주사위를 N번 던져서 나올 수 있는 모든 경우를 출력하는 프로그램을 작성하시오.
 *
 * 위 문제는 for문으로 풀 수 없다.
 * N이 2이면 2중 for
 * N이 3이면 3중 for
 * N이 4이면 4중 for
 */
//class Run {
//    public static void main(String[] args) {
//        new Dice().DFS(1);
//    }
//}

public class Dice {
    public static int N = 2;
    public static int[] arr = new int[11];
    public void DFS(int depth) {
        // 1. 정답인 경우
        // 2. 불가능한 경우
        if (depth > N) {
            for (int i = 1; i <= N; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return ;
        }
        // 3. 다음 경우 호출
        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            DFS(depth + 1);
        }
    }
}
