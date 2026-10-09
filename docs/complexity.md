# Complexity Reference

Let `V` be the number of campus locations, `E` the number of campus roads, `n` the number of items/students, and `C` a knapsack capacity.

| Component | Main operation | Complexity |
|---|---|---:|
| Array / StudentArray | Access by index | O(1) |
| Array / StudentArray | Search by student ID | O(n) |
| Array / StudentArray | Delete by student ID | O(n) |
| Linked-list Stack | Push / Pop / Peek | O(1) |
| Linked-list Queue | Enqueue / Dequeue / Peek | O(1) |
| Doubly-linked Deque | Add/remove at either end | O(1) |
| Custom HashMap | Put / Get / Remove average | O(1) average |
| Custom HashMap | Put / Get / Remove worst case | O(n) |
| Max Heap | Insert / Extract Max | O(log n) |
| Priority Heap | Insert / Extract highest priority | O(log n) |
| AVL Tree | Search / Insert | O(log n) |
| Binary Search Tree | Search / Insert average | O(log n) average |
| Binary Search Tree | Search / Insert worst case | O(n) |
| Linear Search | Search | O(n) |
| Binary Search | Search | O(log n) |
| Merge Sort | Sort | O(n log n) |
| Quick Sort | Sort average | O(n log n) average |
| Quick Sort | Sort worst case | O(n²) |
| BFS | Graph traversal | O(V + E) |
| DFS | Graph traversal | O(V + E) |
| Dijkstra | Weighted shortest paths with binary heap | O((V + E) log V) |
| Kruskal | Minimum spanning tree | O(E log E) |
| Prim | Minimum spanning tree with heap | O(E log V) |
| Activity Selection | Sort + greedy scan | O(n log n) |
| 0/1 Knapsack | Dynamic programming | O(nC) time |

These are asymptotic references for the implemented educational versions; constants and implementation details can affect practical runtime.
