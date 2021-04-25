package bruteforce;

import java.util.HashSet;
import java.util.Set;

class Run2 {
    public static void main(String[] args) {
        System.out.println(new FindPrimeNumber().solution("011"));
    }
}

public class FindPrimeNumber {

    public int solution(String numbers) {
        boolean[] check = new boolean[numbers.length()];
        Set<Integer> set = new HashSet<>();
        String temp = "";
        for (int i = 1; i <= numbers.length(); i++)
            DFS(i, numbers, temp, check, set);
        return (set.size());
    }

    public void DFS(int depth, String numbers, String temp, boolean[] check, Set<Integer> set) {
        if (depth == temp.length() && isPrimeNumber(Integer.parseInt(temp))) {
            set.add(Integer.parseInt(temp));
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!check[i]) {
                check[i] = true;
                temp += numbers.charAt(i);
                DFS(depth, numbers, temp, check, set);
                temp = temp.substring(0, temp.length() - 1);
                check[i] = false;
            }
        }
    }

    public boolean isPrimeNumber(int number) {
        if (number < 2)
            return (false);
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0)
                return (false);
        }
        return (true);
    }
}