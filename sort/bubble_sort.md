# 버블정렬 (Bubble sort)  

---

효율성이 가장 떨어지는 알고리즘  

## 옆에 있는 값과 비교해서 더 작은 값을 앞으로 보내면 어떨까?

---

```c
#include<stdio.h>

int main(int argc, char **argv) {

    int i, j, temp;
    int array[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
    for (i = 0; i < 10; i++) {
        for (j = 0; j < 9 - i; j++) {
            if (array[j] > array[j + 1]) {
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }

    for (i = 0; i < 10; i++) {
        printf("%d ", array[i]);
    }

    return 0;
}
```

---

`버블 정렬의 시간 복잡도는 O(N^2)입니다.`  

1 2 3 4 5 6 7 8 9 10  

10 9 8 7 ... 1 (scan)  
 
`등차수열`  

=> 10 * (10 + 1) / 2 = 55  
=> N * (N + 1) / 2  
=> `O(N * N)`  

![](/img/n^2.png)  

비효율적인 알고리즘 
