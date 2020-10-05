# 그래프의 표현  

| 번호 | 문제 | 코드 |  
|:---:|:---:|:---|  
| 13023❗️ | [ABCDE](https://www.acmicpc.net/problem/13023) | [java](https://github.com/hwlee9505/Algorithm/blob/master/boj/13023.java) |  

# 그래프의 탐색  

| 번호 | 문제 | 코드 |  
|:---:|:---:|:---|  
| 1260  | [DFS와 BFS](https://www.acmicpc.net/problem/1260) | [java](https://github.com/hwlee9505/Algorithm/blob/master/boj/1260.java) |  

# 연결 요소  

| 번호 | 문제 | 코드 |  
|:---:|:---:|:---|  
| 11724 | [연결 요소의 개수](https://www.acmicpc.net/problem/11724) | [java](https://github.com/hwlee9505/Algorithm/blob/master/boj/11724.java) |  

# 이분 그래프  

| 번호 | 문제 | 코드 |  
|:---:|:---:|:---|  
| 1707❗️  | [이분 그래프](https://www.acmicpc.net/problem/1707) | [java](https://github.com/hwlee9505/Algorithm/blob/master/boj/1707.java) |

# 플러드 필

| 번호 | 문제 | 코드 |
|:---:|:---:|:---|
| 2667  | [단지번호붙이기](https://www.acmicpc.net/problem/2667) | [java](https://github.com/hwlee9505/Algorithm/blob/master/boj/2667.java) |
| 4963  | [섬의 개수](https://www.acmicpc.net/problem/4963) | [java](https://github.com/hwlee9505/Algorithm/blob/master/boj/4963.java) |

# BFS  

| 번호 | 문제 | 코드 |
|:---:|:---:|:---|
| 2178  | [미로 탐색](https://www.acmicpc.net/problem/2178) | [java](https://github.com/hwlee9505/Algorithm/blob/master/boj/2178.java) |
| 7576  | [토마토](https://www.acmicpc.net/problem/7576) | [java](https://github.com/hwlee9505/Algorithm/blob/master/boj/7576.java) |
| 1697  | [숨바꼭질](https://www.acmicpc.net/problem/1697) | [java](https://github.com/hwlee9505/Algorithm/blob/master/boj/1697.java) |
| 14226 | [이모티콘](https://www.acmicpc.net/problem/14226) | [java](https://github.com/hwlee9505/Algorithm/blob/master/boj/14226.java) |

# 덱 사용하기

| 번호 | 문제 | 코드 |
|:---:|:---:|:---|
| 13549  | [숨바꼭질 3](https://www.acmicpc.net/problem/13549) | [java](https://github.com/hwlee9505/Algorithm/blob/master/boj/13549.java) |
| 1261  | [알고스팟](https://www.acmicpc.net/problem/1261) | [java](https://github.com/hwlee9505/Algorithm/blob/master/boj/1261.java) |

# BFS

| 번호 | 문제 | 코드 |
|:---:|:---:|:---|
| 2206  | [벽 부수고 이동하기](https://www.acmicpc.net/problem/2206) | [java](https://github.com/hwlee9505/Algorithm/blob/master/boj/2206.java) |
| 3055  | [탈출](https://www.acmicpc.net/problem/3055) | [java](https://github.com/hwlee9505/Algorithm/blob/master/boj/3055.java) |
---

# 공간 복잡도

- 인접 행렬: `O(V^2)`  
- 인접 리스트: `O(E)`  

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
=> `O(V^2)`  

2. 인접 리스트  
=> `O(V + E)`  
---

# BFS  
너비 우선 탐색  

큐를 이용해서 지금 위치에서 갈 수 있는 것을 모두 큐에 넣는 방식  
큐에 넣을 때 방문했다고 채크해야 한다.  


1. 인접 행렬  
=> `O(V^2)`  

2. 인접 리스트  
=> `O(V + E)`  


---

# 연결 요소

- 지금 까지 봐왔던 나누어지지 않은 그래프는 `연결 그래프`라 한다.  

![](/img/connectedComponent.png)  

- 각각 나누어진 그래프를 `연결 요소`라고 한다.  
- 연결 요소에 속한 모든 정점을 연결하는 경로가 있어야 한다.  
- 또, 다른 연결 요소에 속한 정점과 연결하는 경로가 있으면 안된다.  

---  

# 이분 그래프

![](/img/bipartiteGraph.png)  

- 그래프를 다음과 같이 A와 B로 나눌 수 있으면 이분 그래프라고 한다.  
- A에 포함되어 있는 정점끼리 연결된 간선이 없음  
- B에 포함되어 있는 정점끼리 연결된 간선이 없음  
- 모든 간선의 한 끝 점은 A에, 다른 끝 점은 B에  

1. 3-c를 이용해서 피아식별을 한다.  
2. 어떤 정접은 그 인접리스트에 담겨있는 정점들과 피아식별이 가능해야 한다.  


---

# 플러드 필

- 어떤 위치와 연결된 모든 위치를 찾는 알고리즘  

---

# BFS  

BFS 목적은 임의의 정점에서 시작해서, 모든 정점을 한 번씩 방문하는 것이다.  

BFS는 최단 거리를 구하는 알고리즘이다.**(특정한 조건을 만족했을 시애)  

- 특정조건  
BFS는 `모든 가중치가 1`일 때, `최단 거리를 구하는 알고리즘`이다.  

- BFS를 이용해서 해결할 수 있는 문제(`최단 거리`)는 다음과 같은 조건을 만족해야 한다.  
1. `최소 비용` 문제여야 한다.  
2. `간선의 가중치`가 `1`이어야 한다.  
3. 정점과 간선의 개수가 적어야 한다.(적다는 것은 문제의 조건에 맞춰서 해결할 수 있다는 것을 의미한다.)  
ㄴ 시간제한, 메모리제한을 지키기 위해서  

---  

# 벽 부수고 이동하기

![](/img/movingtheWallPassage.jpg)  

---

# 탈출

![](/img/escape.jpg)  

---
