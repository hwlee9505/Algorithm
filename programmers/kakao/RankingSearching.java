import java.util.*;

/**
 *	정확도에서는 통과 되었으나
 *	효율성 체크에서 광탈되어 다른 분 코드를 참고하였다.
 *
 *	map, bitMasking, binarySearch
 *
 */
public class RankingSearching {
    public static void main(String[] args) {
        int[] arr = new RankingSearchingSupplement.Solution().solution(new String[]{
                        "java backend junior pizza 150",
                        "python frontend senior chicken 210",
                        "python frontend senior chicken 150",
                        "cpp backend senior pizza 260",
                        "java backend junior chicken 80",
                        "python backend senior chicken 50"},
                new String[] {
                        "java and backend and junior and pizza 100",
                        "python and frontend and senior and chicken 200",
                        "cpp and - and senior and pizza 250",
                        "- and backend and senior and - 150",
                        "- and - and - and chicken 100",
                        "- and - and - and - 150"
                });
        for (int i : arr)
            System.out.print(i + " ");
    }

    static class Solution {
        Map<String, Integer> wordMap = new HashMap<>();
        List<List<Integer>> scoreList = new ArrayList<>();
        public int[] solution(String[] info, String[] query) {
            wordMap.put("-", 0);
            wordMap.put("cpp", 1);
            wordMap.put("java", 2);
            wordMap.put("python", 3);
            wordMap.put("frontend", 1);
            wordMap.put("backend", 2);
            wordMap.put("junior", 1);
            wordMap.put("senior", 2);
            wordMap.put("chicken", 1);
            wordMap.put("pizza", 2);
            for (int i = 0; i < 4 * 3 * 3 * 3; ++i)
                scoreList.add(new ArrayList<>());
            for (String str : info)
            {
                String[] word = str.split(" ");
                int[] arr = {
                        wordMap.get(word[0]) * 3 * 3 * 3,
                        wordMap.get(word[1]) * 3 * 3,
                        wordMap.get(word[2]) * 3,
                        wordMap.get(word[3])
                };
                int score = Integer.parseInt(word[4]);
                for (int i = 0; i < (1<<4); ++i)
                {
                    int idx = 0;
                    for (int j = 0; j < 4; ++j)
                    {
                        if ((i & (1<<j)) != 0)
                        {
                            idx += arr[j];
                        }
                    }
                    scoreList.get(idx).add(score);
                }
            }
            // 모든 경우의 수에 score 로 왜 초기화 시켰을까? why??
            for (int i = 0; i < 4 * 3 * 3 * 3; ++i)
                Collections.sort(scoreList.get(i));
            int[] answer = new int[query.length];
            for (int i = 0; i < query.length; ++i)
            {
                String[] word = query[i].split(" ");
                int idx = wordMap.get(word[0]) * 3 * 3 * 3 +
                        wordMap.get(word[2]) * 3 * 3 +
                        wordMap.get(word[4]) * 3 +
                        wordMap.get(word[6]);
                int score = Integer.parseInt(word[7]);
                int ret = Collections.binarySearch(scoreList.get(idx), score);
                if (ret < 0) // ex) 그런 점수가 없는 경우 ?????
                {
                    ret = - (ret + 1);
                }
                else // ex) 점수가 같은게 여러개면 한개만 idx를 반환해서 문제가 된다. // 로우 바운드 확인
                {
                    for (int j = ret - 1; j >= 0; --j)
                    {
                        if (scoreList.get(idx).get(j) == score)
                            ret = j;
                        else
                            break;
                    }
                }
                answer[i] = scoreList.get(idx).size() - ret;
            }
            return (answer);
        }
    }
}
