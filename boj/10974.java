import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 전체 시간 복잡도는 어떻게 될까?
// O(N * N!) => O(N!)이지 않을까?

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }


        do{

            for(int i : arr){
                System.out.print(i+" ");
            }
            System.out.println();
        }while(ascendingPermutation(arr));

    }

    public static boolean ascendingPermutation(int[] arr) {

        int iIdx = arr.length - 1;
        int jIdx = arr.length - 1;

        while (iIdx > 0 && arr[iIdx - 1] >= arr[iIdx]) {
            iIdx--;
        }

        if (iIdx == 0) {
            return false;
        }

        while (jIdx >= iIdx && arr[jIdx] <= arr[iIdx - 1]) {
            jIdx--;
        }

        int temp = arr[iIdx -1];
        arr[iIdx -1] = arr[jIdx];
        arr[jIdx] = temp;

        jIdx = arr.length -1;

        while(iIdx < jIdx){
            temp = arr[iIdx];
            arr[iIdx] = arr[jIdx];
            arr[jIdx] = temp;

            iIdx++;
            jIdx--;
        }
        return true;
    }
}
