package services;

import datastructures.PriorityHeap;
import model.ServiceRequest;

public class PriorityRequestQueue {

    private PriorityHeap<ServiceRequest> heap;

    public PriorityRequestQueue(int capacity) {

        heap = new PriorityHeap<>(
                capacity,
                (request1, request2) ->
                        Integer.compare(
                                request1.getPriority().ordinal(),
                                request2.getPriority().ordinal()
                        )
        );
    }

    public void addRequest(
            ServiceRequest request) {

        heap.insert(request);
    }

    public ServiceRequest processNext() {

        return heap.extractMax();
    }

    public ServiceRequest nextRequest() {

        return heap.peek();
    }

    public boolean isEmpty() {

        return heap.isEmpty();
    }

    public int pendingRequests() {

        return heap.size();
    }
}
