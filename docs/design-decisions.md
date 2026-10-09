# Smart Campus DSA — Design Decisions

## Student Management

Students are managed using a custom array-based structure.

Reason:
- Demonstrates array operations
- Simple sequential traversal
- Useful for learning O(n) search

## Resource Management

Resources are stored using a custom HashMap.

Reason:
- Resource IDs are unique lookup keys
- Average O(1) lookup

## Service Requests

Service requests are managed using a priority heap.

Reason:
- Critical requests should be processed before lower-priority requests
- Peek is O(1)
- Processing is O(log n)

## Navigation

Navigation history uses a stack.

Reason:
- Most recently visited location should be returned first

## Normal Service Counter

Normal student waiting uses a queue.

Reason:
- FIFO behavior

## Campus Tasks

Campus tasks use a deque.

Reason:
- Normal tasks can enter from the rear
- Urgent tasks can enter from the front