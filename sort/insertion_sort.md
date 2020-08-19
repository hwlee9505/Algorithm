# 삽입정렬 (Insertion Sort)

---

## 각 숫자를 적절한 위치에 삽입하면 어떨까?  



_ 1 _ 5 _ 10 _ 8 7 5 4 3 2 9  

ex) 8을 기준으로 보았을 때  
8의 왼쪽은 이미 정렬된 상태이기 때문에 다시 살펴볼 필요가 없다.  

=> 거의 정렬된 상태에서는 제일 빠른 정렬 알고리즘이다.  

=> 기본적으로 `정렬이 되어있다고 가정`을 한다는 점에서  
특정한 경우에 따라 굉장히 빠른 속도를 자랑한다.  

=> 버블, 선택 정렬보다 빠르다.  

---

```c
#include<stdio.h>

int main(int argc, char **argv) {

    int i, j, temp;
    int array[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

    for (i = 0; i < 10; i++) {
        j = i;
        while(array[j] > array[j+1]){
            temp = array[j];
            array[j] = array[j+1];
            array[j+1] = temp;
            j--;
        }
    }

    for (i = 0; i < 10; i++) {
        printf("%d ", array[i]);
    }

    return 0;
}
```

---

`선택 정렬의 시간 복잡도는 O(N^2)입니다.`

