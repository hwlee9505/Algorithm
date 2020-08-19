## 시간 복잡도 O(N^2)

아무리 지금 씨언어를 공부있다고 해도 씨 라이브러리까지 사용은 아닌거 같아  
자바로 풀겠다.  

1. [BOJ 문자열 정렬](https://www.acmicpc.net/problem/1181)  

2. [BOJ 조금 더 복잡한 정렬](https://www.acmicpc.net/problem/1431)  
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<String>();

        for (int i = 0; i < size; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, comparator);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {

            if (s1.length() < s2.length()) {
                return -1;
            } else if (s1.length() > s2.length()) {
                return 1;
            } else {
                if(calculateSum(s1) < calculateSum(s2)){
                    return -1;
                }else if(calculateSum(s1) > calculateSum(s2)){
                    return 1;
                }else{
                    return s1.compareTo(s2);
                }
            }
        }
    };

    public static int calculateSum(String str) {

        int idx = 0;
        int sum = 0;

        while (idx < str.length()) {

            if (str.charAt(idx) >= '0' && str.charAt(idx) <= '9') {
                sum += str.charAt(idx) - '0';
            }
            idx++;
        }
        return sum;
    }
}
```
3. [BOJ 매우 빠르게 정렬](https://www.acmicpc.net/problem/10989)  


