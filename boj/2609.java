public class Main {

    public static void main(String[] args) {

        // 최대 공약수 Greatest Common Divisor
        // 두 수 A와 B의 최대공약수 G는 A와 B의 공통된 약수 중에서 가장 큰 정수이다.
        // 최대 공약수를 구하는 가장 쉬운 방법은 2부터 min(A,B)까지 모든 정수로 나누어 보는 방법
        // 최대 공약수가 1인 두 수를 서로소(Coprime)라고 한다.

        int a = 24;
        int b = 18;


        System.out.println(gcd2(a, b));
        System.out.println(gcd3(a, b));

    }

    // O(N)
    public static int gcd(int a, int b) {

        int g = 1;
        for (int i = 2; i < Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                g = i;
            }
        }
        return g;
    }

    // 유클리드 호제법
    // O(logN)

    public static int gcd2(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd2(b, a % b);
    }

    public static int gcd3(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
