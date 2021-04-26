package hash;

import java.util.HashMap;
import java.util.Map;

class Run {
    public static void main(String[] args) {
        System.out.println(new UnfinishedRunner().solution(new String[]{"mislav", "stanko", "mislav", "ana"},
                new String[]{"stanko", "ana", "mislav"}));
    }
}

public class UnfinishedRunner {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();


        for (String s : participant) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            }
            else {
                int value = map.get(s) + 1;
                map.put(s, value);
            }
        }
        // ㄴ 와 동일
        // for (String s : participant) {
        // map.put(s, map.getOrDefault(s, 0) + 1);
        // }

        for (String s : completion)
            map.put(s, map.get(s) - 1);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }

        return "";
    }
}