# Graph Search (DFS, BFS)

Depth-First Search (DFS)  
Breadth-First Search (BFS)  

---

## Depth-First Search  

이진 트리를 순회했던 inorder, preorder, postorder들은 DFS에 속한다.  

DFS with Recursion  

![](/img/dfs.png)

---

## Breadth-First Search   

레벨 단위로 검색  

![](/img/bfs.png)

---

## 둘의 이동경로 순서 비교  

![](/img/sequence.png)  

---

## DFS와 BFS의 구현 방법

[DFS: Stack](https://www.youtube.com/watch?v=_hxFgg7TLZQ&list=PLjSkJdbr_gFY8VgactUs6_Jc9Ke8cPzZP&t=1m30s)  
[DFS: Recursion](https://www.youtube.com/watch?v=_hxFgg7TLZQ&list=PLjSkJdbr_gFY8VgactUs6_Jc9Ke8cPzZP&t=5m19s)  

[BFS: Queue](https://www.youtube.com/watch?v=_hxFgg7TLZQ&list=PLjSkJdbr_gFY8VgactUs6_Jc9Ke8cPzZP&t=3m11s)  

---

## DFS(stack), DFS(recursion), BFS(queue) 구현 소스

```java
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

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

    public void enqueue(T item) {
        Node<T> t = new Node<T>(item);

        // queue는 후위 삽입     ,   처음 들어온 노드는 first 와 last가 모두 t
        if (last != null) {
            last.next = t;
        }
        last = t;
        if (first == null) {
            first = last;
        }
    }

    public T dequeue() {
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

class Graph {
    class Node {
        int data;
        LinkedList<Node> adjacent;  //  인접한 노드들의 관계는 LinkedList로 표현
        boolean marked; // 방문했는지 표시하는 flag

        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }

    Node[] nodes;

    Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    // 두 노드의 관계를 저장하는 함수 enqueueEdge()
    void enqueueEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    void dfs() {
        dfs(0);
    }

    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        root.marked = true;
        while (!stack.isEmpty()) {
            Node r = stack.pop();
            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }

    void bfs() {
        bfs(0);
    }

    void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        root.marked = true;
        while (!queue.isEmpty()) {
            Node r = queue.dequeue();
            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    queue.enqueue(n);
                }
            }
            visit(r);
        }
    }

    void dfsR(Node r) {

        if (r == null) return;
        r.marked = true;
        visit(r);
        for (Node n : r.adjacent) {
            if (n.marked == false) {
                dfsR(n);
            }
        }
    }

    void dfsR(int index) {

        Node r = nodes[index];
        dfsR(r);
    }

    void dfsR() {
        dfsR(0);
    }

    void visit(Node n) {
        System.out.print(n.data + " ");
    }

}
/*
------------------------
   0
  /
 1 -- 3   7
 |  / |\ /
 | /  | 5
 2 -- 4  \
          6 - 8
*/


public class Main {

    public static void main(String[] args) {

        Graph g = new Graph(9);
        g.enqueueEdge(0, 1);
        g.enqueueEdge(1, 2);
        g.enqueueEdge(1, 3);
        g.enqueueEdge(2, 4);
        g.enqueueEdge(2, 3);
        g.enqueueEdge(3, 4);
        g.enqueueEdge(3, 5);
        g.enqueueEdge(5, 6);
        g.enqueueEdge(5, 7);
        g.enqueueEdge(6, 8);
//        g.dfs();
//        g.bfs();
        g.dfsR();

    }
}
```
