# 그래프의 탐색 (DFS, BFS)

| 번호 | 문제 | 코드 |
|:---:|:---:|:---|
| 13023 | [ABCDE](https://www.acmicpc.net/problem/13023) | [java](https://github.com/hwlee9505/Algorithm/blob/master/boj/13023.java) |
| 1260  | [DFS와 BFS](https://www.acmicpc.net/problem/1260) | [java](https://github.com/hwlee9505/Algorithm/blob/master/boj/1260.java) |
| 11724 | [연결 요소의 개수](https://www.acmicpc.net/problem/11724) | [java](https://github.com/hwlee9505/Algorithm/blob/master/boj/11724.java) |

---

# 공간 복잡도

- 인접 행렬: O(V^2)  
- 인접 리스트: O(E)  

---

# 목적  

시작점 x 시작해서 모든 정점을 1번씩  

--- 

# DFS  
깊이 우선 탐색  

스택을 이용해서 갈 수 있는 만큼 최대한 많이 가고  
갈 수 없으면 이전 정점으로 돌아간다.  

재귀 호출을 이용해서 구현할 수 있다.  

1. 인접 행렬  
=> O(V^2)  

2. 인접 리스트  
=> O(V + E)  
---

# BFS  
너비 우선 탐색  

큐를 이용해서 지금 위치에서 갈 수 있는 것을 모두 큐에 넣는 방식  
큐에 넣을 때 방문했다고 채크해야 한다.  


1. 인접 행렬  
=> O(V^2)  

2. 인접 리스트  
=> O(V + E)  


---

# 연결 요소

- 지금 까지 봐왔던 나누어지지 않은 그래프는 연결 그래프라 한다.  

- 각각 나누어진 그래프를 연결 요소라고 한다.  
- 연결 요소에 속한 모든 정점을 연결하는 경로가 있어야 한다.  
- 또, 다른 연결 요소에 속한 정점과 연결하는 경로가 있으면 안된다.    

---  
