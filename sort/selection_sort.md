#선택정렬 (Selection sort)

---

가장 작은 것을 선택해서 제일 앞으로 보내면 어떨까?  

가장 작은 것을 선택해서 제일 앞으로 보내는 알고리즘  

---

```c
#include<stdio.h>

int main(int argc, char **argv) {

    int i, j, min, index, temp;
    int array[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
    for (i = 0; i < 10; i++) {
        min = 9999;
        for (j = i; j < 10; j++) {
            if (min > array[j]) {
                min = array[j];
                index = j;
            }
        }
        temp = array[i];
        array[i] = array[index];
        array[index] = temp;
    }
    for (i = 0; i < 10; i++) {
        printf("%d ", array[i]);
    }
    return 0;
}
```  

---

`선택 정렬의 시간 복잡도는 O(N^2)입니다.`  

1 2 3 4 5 6 7 8 9 10  

10 9 8 7 ... 1 (scan)  

=> 10 * (10 + 1) / 2 = 55  
=> N * (N + 1) / 2  
=> N * N  
=> `O(N * N)`  

![](/img/n^2.png)  
비효율적이다.
