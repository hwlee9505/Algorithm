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


1. [BOJ 100만 개 정렬](https://www.acmicpc.net/problem/2751)  
