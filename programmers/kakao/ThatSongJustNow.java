import java.util.ArrayList;
import java.util.List;

public class ThatSongJustNow {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(
                "ABCDEFG",
                new String[]{
                        "12:11,13:12,WORLD123,CDEFABGAAABBB",
                        "1:00,13:15,HI,CDEFGAB",
                        "12:00,12:15,HELLO2,CDEFGAB",
                        "12:00,12:15,HELLO1,CDEFGAB",
                }));
        System.out.println(new Solution().solution(
                "ABCDEFG",
                new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(new Solution().solution(
                "CC#BCC#BCC#BCC#B",
                new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(new Solution().solution(
                "ABC",
                new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(new Solution().solution(
                "ABC",
                new String[]{"11:50,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }

    static class Solution {
        public static List<String> answer;
        public String solution(String m, String[] musicinfos) {
            answer = new ArrayList<>();
            List<Integer> minutes = new ArrayList<>();
            m = substituteToSheetMusic(m);
            for (int i = 0; i < musicinfos.length; i++)
            {
                String[] strings = musicinfos[i].split(",");
                strings[3] = substituteToSheetMusic(strings[3]);
                String[] time1 = strings[0].split(":");
                String[] time2 = strings[1].split(":");
                int minute1 = Integer.parseInt(time2[1]) + (60 * Integer.parseInt(time2[0]));
                int minute2 = Integer.parseInt(time1[1]) + (60 * Integer.parseInt(time1[0]));
                int minute = minute1 - minute2;
                System.out.println("minute = " + minute);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < minute; j++)
                    sb.append(strings[3].charAt(j % strings[3].length()));
                if (sb.toString().contains(m))
                {
                    minutes.add(minute);
                    answer.add(strings[2]);
                }
            }
            if (answer.size() == 0)
                return ("(None)");
            int idx = 0;
            if (answer.size() > 2)
            {
                int max = minutes.get(0);
                for (int i = 1; i < minutes.size(); i++)
                {
                    if (max < minutes.get(i))
                        max = minutes.get(i);
                }
                for (int i = minutes.size() - 1; i >= 0; i--) {
                    if (max == minutes.get(i))
                        idx = i;
                }
            }
            return answer.get(idx);
        }

        public String substituteToSheetMusic(String str)
        {
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < str.length() - 1; i++)
            {
                if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                {
                    if (str.charAt(i + 1) == '#')
                        list.add((char)(str.charAt(i) + ('a' - 'A')));
                    else
                        list.add(str.charAt(i));
                }
            }
            if (str.charAt(str.length() - 1) != '#')
                list.add(str.charAt(str.length() - 1));
            StringBuilder sb = new StringBuilder();
            for (char c : list)
                sb.append(c);
            return (sb.toString());
        }
    }
}

