# 퀵 정렬 (Bubble sort)

---

## 특정한 값을 기준으로 큰 숫자와 작은 숫자를 나누면 어떨까?  

특정한 기준으로 큰 숫자와 작은 숫자를 서로 교환한 뒤에 배열을 반으로 나눈다.  

퀵정렬에서는 반으로 나눌 기준 값이 있다.  
`퍼벗(pivot)`  

소스코드를 보면 `키 값보다 작은 값을 만날 때까지` 반복하는 부분에서  
j가 start보다 클 때에 한 해서만 while()이 수행되도록 처리되어 있는데  
이는 항상 왼쪽에 있는 값과 피벗 값을 교환하기 때문이다.  

오른쪽에 있는 값은 피벗 값과 교환되지 않으므로 처리해 줄 필요가 없다.  

퀵 정렬 알고리즘은 기본적으로 N번씩 탐색하되 반으로 쪼개 들어간다는 점에서 `log N`을 곱한 복잡도를 가진다.  


---

```c
#include<stdio.h>

int number = 10;
int data[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

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

int main(int argc, char **argv) {

    quickSort(data,0, number-1);
    int i;
    for(i = 0; i < number; i++){
        printf("%d ",data[i]);
    }

    return 0;
}
```

---

`퀵 정렬의 시간 복잡도는 O(N * logN)입니다.`  

`퀵 정렬의 최악 시간 복작ㅂ도는 O(N^2)입니다.`  
이는 정렬되어 있는 경우 분할의 이점을 사용하지 못하기 때문이다.  
