import java.util.LinkedList;
import java.util.List;

/**
 *	문제 이해와 예외처리만 잘한다면 할만한 문제
 */

public class Cache {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(3, new String[]{
                "Jeju", "Pangyo",
                "Seoul", "NewYork",
                "LA", "Jeju",
                "Pangyo", "Seoul",
                "NewYork", "LA"}));
        System.out.println(new Solution().solution(3, new String[]{
                "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        System.out.println(new Solution().solution(2, new String[]{
                "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(new Solution().solution(5, new String[]{
                "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(new Solution().solution(2, new String[]{
                "Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(new Solution().solution(0, new String[]{
                "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }

    static class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            List<String> cache = new LinkedList<>();
            for (String cityTemp : cities)
            {
                String city = cityTemp.toLowerCase();
                if (cache.contains(city))           // hit
                {
                    cache.remove(city);
                    cache.add(city);
                    answer++;
                }
                else if (cache.size() < cacheSize)  // miss
                {
                    cache.add(city);
                    answer += 5;
                }
                else                                // miss + cache 용량 초과
                {
                    if (cacheSize > 0)
                    {
                        cache.remove(0);
                        cache.add(city);
                    }
                    answer += 5;
                }
            }
            return (answer);
        }
    }
}

