## 시간 복잡도 O(N^2)  

1. [BOJ 세 숫자 정렬](https://www.acmicpc.net/problem/2752)  

```c
#include<stdio.h>

int arr[3];

int main(void){

    int i, j, min, idx, temp;

    for(i = 0; i < 3; i++){
        scanf("%d", &arr[i]);
    }

    for(i = 0 ; i < 3; i++){
        min = 1000001;
        for(j = i ; j < 3; j++){
            if(min > arr[j]){
                min = arr[j];
                idx = j;
            }
        }
        temp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = temp;
    }

    for(i = 0; i < 3; i++){
        printf("%d ", arr[i]);
    }

    return 0;
}
```

2. [BOJ 단순 정렬](https://www.acmicpc.net/problem/2750)  

```c
#include<stdio.h>

int main(void){

    int size = 0;
    scanf("%d", &size);
    int arr[size];
    int i, j, min, idx, temp;
    for(i = 0 ; i < size; i++){
        scanf("%d" , &arr[i]);
    }

    for(i = 0 ; i < size; i ++){
        min =1001;
        for(j = i; j < size; j++){
            if(min > arr[j]){
                min = arr[j];
                idx = j;
            }
        }
        temp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = temp;
    }

    for(i = 0 ; i < size; i++){
        printf("%d\n", arr[i]);
    }

    return 0;
}
```
---

## 시간 복잡도 O(N * logN)  

온라인 cpu는 1초에 1억개 가량을 돌릴수 있다고 생각하면된다.  
이번 문제의 경우는 100만 개의 데이터를 정렬하고 싶어한다.  
근데, O(N^2)의 로직으로 풀 경우  
100만 * 100만은 1억을 훌쩍 넘겨버린다.  

즉, O(N * logN) 시간복잡도를 가지는 정렬 알고리즘을 사용해야 한다.

1. [BOJ 100만 개 정렬](https://www.acmicpc.net/problem/2751)  

퀵 정렬은 `O(N * logN)`이지만  
정렬되어 있는 배열의 경우(최악의 경우)에는  
`O(N * N)`이다.  

이 문제 테스트 케이스에 정렬된 배열이 주는 경우가 있으므로 실패..  

고로 동빈나님은 library를 적극 권장한다.  

```c
#include<stdio.h>

void quickSort(int *data, int start, int end) {

    if (start >= end) {    //  원소가 1개인 경우
        return;
    }

    int pivot = start;     // 피봇은 첫번째 원소
    int i = start + 1;
    int j = end;
    int temp;

    while (i <= j) {         // 엇갈릴 떄까지 반복
        while (data[i] <= data[pivot]) { // 피봇값 보다 큰 값을 만날 때까지 오른쪽으로 이동
            i++;
        }
        while (data[j] >= data[pivot] && j > start) { // 피봇값 보다 작은 값을 만날 때까지 왼쪽으로 이동 , j는 start보다 큼
            j--;
        }
        if (i > j) {    // 현재 엇갈린 상태면 피봇값과 교체
            temp = data[pivot];
            data[pivot] = data[j];
            data[j] = temp;
        } else {    // 엇갈리지 않았다면 i와 j를 교체
            temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }

    // 재귀적 함수를 이용
    quickSort(data, start, j-1);
    quickSort(data, j+1, end);

}

int main(void) {

    int number, data[1000000];
    scanf("%d", &number);
    int i;

    for (i = 0; i < number; i++) {
        scanf("%d", &data[i]);
    }

    quickSort(data, 0, number - 1);

    for (i = 0; i < number; i++) {
        printf("%d ", data[i]);
    }


    return 0;
}
```
