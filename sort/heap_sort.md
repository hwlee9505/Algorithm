# 힙 정렬 (Heap Sort)

---

## 힙이란?, 이진트리란?  

- 이진 트리란  

컴퓨터 안에서 데이터를 표현할 때 데이터를 각 노드(Node)에 담은 뒤에 노드를 두 개씩 이어 붙이는 구조를 말한다.  
이 때 트리 구조에 맞게 부모 노드에서 자식 노드로 가지가 뻗힌다.  

이진트리는 모든 노드의 자식 노드가 2개 이하인 노드이다.  

완전 이진트리, 포화 이진트리  

- 힙이란  

최솟값이나 최댓값을 빠르게 찾아내기 위해 완전 이진 트리를 기반으로 하는 트리이다.  
힙에는 최대 힙과 최소 힙이 존재하는데 최대 힙은 부모 노드가 자식 노드보다 큰 힙이라 할 수 있다.  


- 힙 정렬  
힙 정렬을 수행하기 위해서는 `힙 생성 알고리즘(Heapify Algorithm)`을 사용합니다.  

[힙에 더 자세히](https://hwlee9505.github.io/docs/algorithm_heap#binary-heap)  

---

## 힙(Heap)을 이용해 데이터를 정렬하면 어떨까?  

효율성이 가장 떨어지는 알고리즘

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

`힙 정렬의 전체 시간 복잡도는 O(N * logN)입니다.`

1 2 3 4 5 6 7 8 9 10

10 9 8 7 ... 1 (scan)

`등차수열`

=> 10 * (10 + 1) / 2 = 55
=> N * (N + 1) / 2
=> `O(N * N)`

![](/img/n^2.png)

비효율적인 알고리즘
