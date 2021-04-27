package hash;

import java.util.*;
import java.util.stream.Collectors;

public class BestAlbum {

    public static void main(String[] args) {
        int[] arr = new BestAlbum().solution(
                new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500});
        System.out.print("answer: ");
    }

    /**
     * classic   pop   classic   classic   pop
     * 500       600   150       800       2500
     */
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        ArrayList<Integer> answerList = new ArrayList<>();

        /**
         * mapGenres: 각 장르별 가장 많이 들은 곡 선별
         * key:     genres
         * value:   총 장르별 플레이어 횟수
         */
        Map<String, Integer> mapGenres = new HashMap<>();
        for (int i = 0; i < genres.length; i++)
            mapGenres.put(genres[i], mapGenres.getOrDefault(genres[i], 0) + plays[i]);
//        mapGenres.forEach((k,v) -> System.out.print(k + ":" + v + " "));
//        System.out.println();
        /**
         * value:   총 장르별 플레이어 횟수
         * keySetList =>
         * value 를 정렬 리스트
         * 람다식을 이용해서 정렬
         */
        List<String> keySetList = new ArrayList<>(mapGenres.keySet());
        Collections.sort(keySetList, (o1, o2) -> (mapGenres.get(o2).compareTo(mapGenres.get(o1))));

        /**
         * 총 장르별 플레이어 횟수가 내림차순으로 정렬된
         * 장르 리스트
         *
         * 1) classic
         *      for     [classic, pop, classic, classic, pop]
         *       index      0      1      2        3      4
         *      if ( classic == genres[i] )
         *          map.put(index, plays[i])
         *
         *  List<Integer> keyLists = new ArrayList<>(hs.keySet());
         *  또 keyList 플레이어 횟수 많은 순으로 정렬
         *
         * 2) pop
         *      for     [classic, pop, classic, classic, pop]
         *       index      0      1      2        3      4
         *      if ( pop == genres[i] )
         *          map.put(index, plays[i])
         */
        for (String key : keySetList) {
            Map<Integer, Integer> hs = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                if (key.equals(genres[i])) {
                    hs.put(i, plays[i]);
                }
            }
//            hs.forEach((k, v) -> System.out.print(k + ":" + v + " "));
            List<Integer> keyLists = new ArrayList<>(hs.keySet());
            keyLists.sort((i1, i2) -> hs.get(i2).compareTo(hs.get(i1)));
//            System.out.println();
//            hs.forEach((k, v) -> System.out.print(k + ":" + v + " "));
            /**
             * 2개 이하로만 뽑아야 하니깐 cnt++ < 2 동안 하는 거다.
             */
            int cnt = 0;
            for (int c : keyLists) {
                if (cnt > 1)
                    break;
                answerList.add(c);
                cnt++;
            }
        }
        answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++)
            answer[i] = answerList.get(i);
        return answer;
    }
}
