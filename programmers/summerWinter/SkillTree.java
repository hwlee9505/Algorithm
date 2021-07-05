import java.util.*;

/**
 *  해시를 이용해서 주어지는 스킬마다 순차적으로 맵핑하였고 for문을 통한 index를 나중에 순서대로 비교해준게 핵심이었다.
 */
public class SkillTree {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("CBD", new String[]{
                "BACDE", "CBADF", "AECB", "BDA"
        }));
    }
    static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            Map<Character, Integer> map = new HashMap<>();
            int value = 1;
            for (char c : skill.toCharArray())
                map.put(c, value++);
            List<Integer> checkList;
            for (String s : skill_trees)
            {
                checkList = new ArrayList<>();
                for (char c : s.toCharArray())
                {
                    if (map.containsKey(c))
                        checkList.add(map.get(c));
                }
                if (checkSorted(checkList))
                    answer++;
            }
            return answer;
        }
        public boolean checkSorted(List<Integer> list)
        {
            for (int i = 0; i < list.size(); i++)
            {
                if (list.get(i) != i + 1)
                    return (false);
            }
            return (true);
        }
    }
}

