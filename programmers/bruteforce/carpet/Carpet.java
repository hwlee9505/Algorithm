package bruteforce;

class Run3 {
    public static void main(String[] args) {
        new Carpet().solution(10, 2);
    }
}

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        for (int i = 3; i <= sum; i ++) {
            if (sum % i == 0) {
                int column = sum / i;
                int row = sum / column;

                if (((column - 2) * (row - 2) == yellow) && column >= row)
                    return new int[] {column, row};
            }
        }
        return (new int[]{});
    }
}
