# 큐 자료구조

[C언어로 쉽게 풀어쓴 자료구조](https://cs.kangwon.ac.kr/~leeck/DS/DS_06.pdf)  
[cs 큐](https://hwlee9505.github.io/docs/algorithm_stackQueue)  

## Java 큐  

```java
import java.util.NoSuchElementException;

class Queue<T> {

    class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    // queue는 앞 뒤로 주소를 알고 있어야 한다. -> 데이터가 들어오거나 나갈때 필요하기 때문에
    private Node<T> first;
    private Node<T> last;

    public void add(T item) {
        Node<T> t = new Node<T>(item);

        // queue는 후위 삽입
        if (last != null) {
            last.next = t;
        }

        last = t;

        if (first == null) {
            first = last;
        }
    }

    public T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        T data = first.data;
        first = first.next; // 앞을 덮어써버림

        if (first == null) {
            last = null;
        }
        return data;
    }

    public T peek() {

        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

}

public class Main {

    public static void main(String[] args) {

        Queue<Integer> q = new Queue<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
    }
}
```

---

## C 원형 큐  

```c
#include <stdio.h>

#define QUEUE_SIZE  10
#define NEXT(index)   ((index+1)%QUEUE_SIZE)  //원형 큐에서 인덱스를 변경하는 매크로 함수

typedef struct Queue //Queue 구조체 정의
{
    int buf[QUEUE_SIZE];//저장소
    int front; //꺼낼 인덱스(가장 오래전에 보관한 데이터가 있는 인덱스)
    int rear;//보관할 인덱스
} Queue;

void init(Queue *queue);//큐 초기화
int is_full(Queue *queue); //큐가 꽉 찼는지 확인
int is_empty(Queue *queue); //큐가 비었는지 확인
void enqueue(Queue *queue, int data); //큐에 보관
int dequeue(Queue *queue); //큐에서 꺼냄

int main(void) {
    int i;
    Queue queue;

    init(&queue);//큐 초기화
    for (i = 1; i <= 5; i++)//1~5까지 큐에 보관
    {
        enqueue(&queue, i);
    }
    while (!is_empty(&queue))//큐가 비어있지 않다면 반복
    {
        printf("%d ", dequeue(&queue));//큐에서 꺼내온 값 출력
    }
    printf("\n");
    return 0;
}

void init(Queue *queue) {
    queue->front = queue->rear = 0; //front와 rear를 0으로 설정
}

int is_full(Queue *queue) {
    //원형 큐에서 꽉 찼는지 비었는지 체크할 수 있게 rear 다음 공간은 빈 상태를 유지합니다.
    return NEXT(queue->rear) == queue->front;//다음 rear가 front와 같으면 꽉 찬 상태
}

int is_empty(Queue *queue) {
    return queue->front == queue->rear;    //front와 rear가 같으면 빈 상태
}

void enqueue(Queue *queue, int data) {
    if (is_full(queue))//큐가 꽉 찼을 때
    {
        printf("큐가 꽉 찼음\n");
        return;
    }
    queue->buf[queue->rear] = data;//rear 인덱스에 데이터 보관
    queue->rear = NEXT(queue->rear); //rear를 다음 위치로 설정
}

int dequeue(Queue *queue) {
    int re = 0;
    if (is_empty(queue))//큐가 비었을 때
    {
        printf("큐가 비었음\n");
        return re;
    }
    re = queue->buf[queue->front];//front 인덱스에 보관한 값을 re에 설정
    queue->front = NEXT(queue->front);//front를 다음 위치로 설정
    return re;
}
```}

