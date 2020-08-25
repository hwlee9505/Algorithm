import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Brute Force 3 단계
 * <p>
 * 1. 문제의 가능한 경우의 수를 계산해본다. (손으로, Permutation or Combination)
 *    Permutation 순열
 *    15 * 28 * 19 = 7980년
 *
 * 2. 가능한 모든 방법을 다 만들어 본다. (하나도 빠짐없어야 한다.)
 * 3. 각각의 방법을 이용해 답을 구해본다.
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int ECount = 1;
        int SCount = 1;
        int MCount = 1;

        int result = 1;

        while (ECount != E || SCount != S || MCount != M) {

            if(E == 0 || S == 0 || M == 0){
                result = 0;
                break;
            }

            if(ECount == 15){
                ECount = 1;
            }else{
                ECount++;
            }

            if(SCount == 28){
                SCount = 1;
            }else{
                SCount++;
            }

            if(MCount == 19){
                MCount = 1;
            }else{
                MCount++;
            }

            result++;
        }

        System.out.println(result);

    }
}
