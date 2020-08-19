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



---

```c
#include <stdio.h>

// 최대힙을 구하는 과정
int number = 9;
int heap[9] = {7, 6, 5, 8, 3, 5, 9, 1, 6};


int main(void) {

    // 먼저 전체 트리 구조를 최대 힙 구조로 바꾼다.

    // 데이터의 갯수가 N개 이므로 전체 트리를 힙 구조로 만드는 복잡도는
    // O(N * logN)이다.
    // 사실상 모든 데이터를 기준으로 힙 생성 알고리즘을 쓰지 않아도 되기 떄문에 O(N)에 가까운 속도를 낸다.

    fputs("트리구조 -> 최대 힙구조 변환\n", stdout);

    for (int i = 1; i < number; i++) {
        int c = i;
        do {
            int root = (c - 1) / 2;     // 특정한 원소의 부모노드를 구하는 공식 이다.
            if (heap[root] < heap[c]) { // 자식이 부모보다 클 경우에 swap
                int temp = heap[root];
                heap[root] = heap[c];
                heap[c] = temp;
            }
            c = root;
        } while (c != 0);

        for (int k = 0; k < 9; k++) {
            printf("%d ", heap[k]);
        }
        fputs("\n", stdout);
    }

    fputs("\n최대 힙구조 -> 최소 힙구조 변환\n", stdout);
    
    // 루트(Root)에 있는 값을 가장 뒤쪽으로 보내면서 힙 트리의 크기를 1씩 빼준다.

    // 크기를 줄여가며 반복적으로 힙을 구성
    for (int i = number - 1; i >= 0; i--) {
        int temp = heap[0];
        heap[0] = heap[i];
        heap[i] = temp;

        int root = 0;
        int c = 1;
        do {
            c = 2 * root + 1;
            // 자식 중에 더 큰 값을 찾기  //  양 갈래중 어디로 갈래?
            if (heap[c] < heap[c + 1] && c < i - 1) {
                c++;
            }
            // 루트보다 자식이 더 크다면 교환
            if (heap[root] < heap[c] && c < i) {
                temp = heap[root];
                heap[root] = heap[c];
                heap[c] = temp;
            }
            root = c;
        } while (c < i);

        for (int k = 0; k < 9; k++) {
            printf("%d ", heap[k]);
        }
        fputs("\n", stdout);
    }
    for (int i = 0; i < 9; i++) {
        printf("%d ", heap[i]);
    }
    return 0;
}
```

---

`힙 정렬의 전체 시간 복잡도는 O(N * logN)입니다.`  

힙 정렬은 병합 정렬과 다르게 별도로 추가적인 배열이 필요하지 않다는 점에서 `메모리 측면에서 몹시 효율적`이다.  
또한 `항상 O(N * logN)을 보장`할 수 있다는 점에서 몹시 강력한 정렬 알고리즘이다.  
이론적으로는 퀵 정렬, 병합 정렬보다 더 우위에 있다고 할 수 있다.  

하지만 단순히 속도만 가지고 비교하면 `퀵정렬`이 평균적으로 더 빠르기 때문에 힙 정렬이 일반적으로 사용되지는 않는다.  
