# Smart Campus DSA Management System

A Java-based Data Structures and Algorithms project that models a small campus and demonstrates practical DSA operations through an interactive console application.

## Features

- Student management using a custom array structure
- Resource directory using a custom hash map
- Priority service requests using a generic priority heap
- Campus navigation using a weighted undirected graph
- BFS and DFS traversal
- Dijkstra shortest-path navigation
- Prim and Kruskal minimum spanning trees
- Greedy activity scheduling
- 0/1 Knapsack resource allocation
- Stack, Queue, Deque, BST, AVL Tree, and heap implementations
- Standalone test/demo programs under `src/tests`

## Requirements

- Java 21 or newer

## Compile

From the project root:

```bash
rm -rf out
mkdir -p out
javac -d out $(find src -name '*.java')
```

On Windows PowerShell, use:

```powershell
Remove-Item -Recurse -Force out -ErrorAction SilentlyContinue
New-Item -ItemType Directory out | Out-Null
javac -d out (Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { $_.FullName })
```

## Run

```bash
java -cp out Main
```

## Core campus locations

- Library
- Canteen
- Academic Block
- Hostel
- Computer Lab

Roads and distances are defined in `src/services/CampusManagementSystem.java`.

## DSA mapping

| Feature | DSA / Algorithm |
|---|---|
| Students | Array |
| Resources | Hash table with chaining |
| Service requests | Priority heap |
| Campus traversal | BFS / DFS |
| Shortest route | Dijkstra |
| Minimum network | Prim / Kruskal |
| Activity scheduling | Greedy activity selection |
| Resource optimization | 0/1 Knapsack dynamic programming |
| Navigation history concept | Stack |
| Waiting line concept | Queue |
| Urgent/normal tasks concept | Deque |

## Testing

The files under `src/tests` are simple Java demo/test programs with `main` methods. After compilation, examples include:

```bash
java -cp out tests.DijkstraTest
java -cp out tests.MSTTest
java -cp out tests.CampusGraphTest
java -cp out tests.Knapsack01Test
```

See `docs/architecture.md`, `docs/algorithms.md`, `docs/complexity.md`, and `docs/design-decisions.md` for the project documentation.
