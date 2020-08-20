# Binary Heaps (Min-Heaps and Max-Heaps)

최소힙, 최대힙  

---

## 최소힙에 노드 삽입하기

Complete Binary Tree를 이룬 상태  
자식이 부모보다 작으면 자리를 바꿈  
이 작업을 계속 반복  

O(logN)의 시간 복잡도  

---

## 최소힙에서 노드 꺼내오기

루트에 값을 뺴온 후에  
완전 이진 트리에서 맨 마지막 노드를 가지고 와서 채운다.  

heapify를 진행한다.  

O(logN)의 시간 복잡도
