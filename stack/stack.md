# 스택 자료구조

[C언어로 쉽게 풀어쓴 자료구조](https://cs.kangwon.ac.kr/~leeck/DS/DS_05.pdf)  
[cs스택](https://hwlee9505.github.io/docs/algorithm_stackQueue)  

```c
#include <stdio.h>
#include <stdlib.h>

#define MAX_STACK_SIZE 10
typedef int element;        // 이걸 보면 자바의 제네릭스가 생각 난다.
typedef struct {
    element stack[MAX_STACK_SIZE];
    int top;
} StackType;

// 스택 초기화 함수
void init(StackType *s) {        // 관련 데이터를 구조체로 묶어서 함수의 파라미터로 전달

    s->top = -1;
    //(*s).top = -1;
}

// 공백 상태 검출 함수
int is_empty(StackType *s) {

    return (s->top == -1);
}

// 포화 상태 검출 함수
int is_full(StackType *s) {

    return (s->top == (MAX_STACK_SIZE - 1));
}

// 삽입 함수
void push(StackType *s, element item) {
    if (is_full(s)) {
        fprintf(stderr, "스택 포화 에러\n");
        return;
    }

    s->stack[++(s->top)] = item;
}

// 삭제 함수
element pop(StackType *s) {

    if (is_empty(s)) {
        fprintf(stderr, "스택 공백 에러\n");
        exit(1);
    }

    return s->stack[(s->top)--];
}

// 피크 함수
element peek(StackType *s) {

    if (is_empty(s)) {
        fprintf(stderr, "스택 공백 에러\n");
        exit(1);
    }
    return s->stack[s->top];
}

int main(void) {

    StackType s1;
    
    init(&s1);
    push(&s1, 1);
    push(&s1, 2);
    push(&s1, 3);
    
    printf("%d \n", pop(&s1));
    printf("%d \n", pop(&s1));
    printf("%d \n", pop(&s1));
    printf("%d \n", peek(&s1));

    return 0;
}
```
