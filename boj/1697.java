import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    public static final int max = 100001;

    public static void main(String[] args)  throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수빈이가 있는 위치
        int n = Integer.parseInt(st.nextToken());

        // 동생이 있는 위치
        int k = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[max];
        int[] dist = new int[max];

        check[n] = true;
        dist[n] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);

        while(!q.isEmpty()){
            int now = q.poll();
            if(now - 1 >=0){
                if(check[now -1] == false){
                    q.offer(now-1);
                    check[now-1] = true;
                    dist[now -1] = dist[now] +1;
                }
            }
            if(now +1 < max){
                if(check[now +1] == false){
                    q.offer(now+1);
                    check[now +1] = true;
                    dist[now +1] = dist[now] +1;
                }
            }
            if(now * 2 < max){
                if(check[now * 2] == false){
                    q.offer(now * 2);
                    check[now * 2] = true;
                    dist[now * 2] = dist[now] + 1;
                }
            }
        }
        System.out.println(dist[k]);
    }
}
