import java.util.*;

/**
 *  다른 사람 풀이에서 따온것 인데
 *  s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
 *  로 풀면 간편하다.
 */
public class Tuple {
    public static void main(String[] args) {
        new Solution().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        new Solution().solution("{{1 ,2,3},{2,1},{1,2,4,3},{2}}");
        new Solution().solution("{{20,111},{111}}");
        new Solution().solution("{{123}}");
        new Solution().solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
    }

    static class Solution {

        Comparator<List<Integer>> myComparator = new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o1.size() - o2.size());
            }
        };

        public static List<List<Integer>> lists;
        public static List<Integer> answer;

        public int[] solution(String s) {
            lists = new ArrayList<>();
            answer = new ArrayList<>();
            String[] arr = s.split("},");
            int idx = 0;
            for (String str : arr) {
                String[] temp = str.split(",");
                lists.add(new ArrayList<>());
                for (String ss : temp) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < ss.length(); i++) {
                        if (ss.charAt(i) >= '0' && ss.charAt(i) <= '9')
                            sb.append(ss.charAt(i));
                    }
                    lists.get(idx).add(Integer.parseInt(sb.toString()));
                }
                idx++;
            }
            Collections.sort(lists, myComparator);
            Set<Integer> set = new HashSet<>();
            for (List<Integer> list : lists) {
                for (int i : list) {
                    if (set.contains(i))
                        continue;
                    set.add(i);
                    answer.add(i);
                }
            }
            int[] answerArr = new int[answer.size()];
            idx = 0;
            for (int i : answer)
                answerArr[idx++] = i;
            return answerArr;
        }
    }
}

