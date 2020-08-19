# 병합 정렬 (Merge Sort)

---

## 일단 반으로 나누고 나중에 합쳐서 정렬하면 어떨까?  

병합 정렬은 정확히 반절씩 나눈다는 점에서 최악의 경우에도 `O(N * logN)`을 보장한다.  
피벗값이 없다.  
병합 정렬의 배열은 `전역 변수`로 선언해야만 한다.

합치는 순간에 정렬을 수행한다.  

`기존의 데이터를 담을 추가적인 배열 공간이 필요하다.`는 점에서 메모리 활용이 비효율 적이다.  

일반적인 경우 `퀵 정렬`보다 느리지만 어떠한 상황에서도 정확히 `O(N * logN)`을 보장할 수 있다는 점에서 몹시 효율적인 알고리즘이다.  


---

```c
#include <stdio.h>

int number = 8;

int size;
int sorted[8];      // 뱡힙정렬 배열은 반드시 전역 변수로 선언
int count = 0;


void merge(int a[], int m, int middle, int n) {

    int i = m;
    int j = middle + 1;
    int k = m;

    // 작은 순서대로 배열에 삽입

    while (i <= middle && j <= n) {
        if (a[i] <= a[j]) {
            sorted[k] = a[i];
            i++;
        } else {
            sorted[k] = a[j];
            j++;
        }
        k++;
    }
    // 남은 데이터도 삽입
    if (i > middle) {     // i 가 먼저 끝난 경우
        for (int t = j; t <= n; t++) {
            sorted[k] = a[t];
            k++;
        }
    } else {
        for (int t = i; t <= middle; t++) {
            sorted[k] = a[t];
            k++;
        }
    }

    // 정렬된 배열을 삽입
    for (int t = m; t <= n; t++) {
        a[t] = sorted[t];
    }
}

void mergeSort(int a[], int m, int n) {
    // 크기가 1보다 큰 경우
    if (m < n) {
        int middle = (m + n) / 2;
        mergeSort(a, m, middle);
        mergeSort(a, middle + 1, n);
        merge(a, m, middle, n);
    }
}

int main(void) {

    int array[] = {7, 6, 5, 8, 3, 5, 9, 1};
    mergeSort(array, 0, number - 1);
    int i;
    for (i = 0; i < number; i++) {
        printf("%d ", array[i]);
    }

    return 0;
}
```

---

`병합 정렬의 시간 복잡도는 O(N * logN)입니다.`

![](/img/merge.png)

