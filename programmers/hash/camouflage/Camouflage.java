package hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Camouflage {

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}}
        ));
        System.out.println(solution(new String[][]{
                {"crowmask", "face"},
                {"bluesunglasses", "face"},
                {"smoky_makeup", "face"}}
        ));
        System.out.println(solution(new String[][]{
                {"12", "head"},
                {"123", "head"},
                {"1234", "head"},
                {"1234", "up"},
                {"1234", "up"},
                {"1234", "down"}
        }));
    }

    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 1;

        for (String[] arr : clothes)
            map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry) it.next();
            answer *= (entry.getValue() + 1);
        }
        return (answer - 1);

//        return Arrays.stream(clothes)
//                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
//                .values()
//                .stream()
//                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    }

}
