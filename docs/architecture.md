# Architecture

The project follows a simple layered design.

## Model layer

`src/model` contains domain objects such as `Student`, `Resource`, `ServiceRequest`, `CampusActivity`, and `ResourceItem`.

## Data-structure layer

`src/datastructures` contains the custom implementations used by the project, including arrays, linked structures, stacks, queues, deques, a hash map, heaps, trees, graph structures, and disjoint sets.

## Algorithm layer

`src/algorithms` contains standalone implementations of searching, sorting, graph traversal, shortest path, minimum spanning tree, greedy scheduling, and dynamic programming.

## Service layer

`src/services` connects the data structures and algorithms to the application domain. `CampusManagementSystem` is the main application facade.

## Console layer

`src/Main.java` provides the interactive user interface. User actions are delegated to the service layer rather than manipulating data structures directly.
