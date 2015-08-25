package Heaps;

public class PriorityQueue {
	HeapSet maxHeap;
	
	public PriorityQueue(HeapSet h){
		buildMaxHeap(h);
	}
	
	public void insertIntoHeap(HeapSet.HeapNode h){
		// insert an item into the heap;
	}
	
	public HeapSet.HeapNode maxofHeap(){
		return maxHeap.heapCollection[0];
	}
	
	public void increaseKey(HeapSet.HeapNode h, int key){
		// change the key of a given item in the heap
	}
	
	private void buildMaxHeap(HeapSet h) {
		for (int i = h.size/2 ; i >=0; i--) {
			maxHeapify(h.heapCollection, i);
		}
	}
	
	private void maxHeapify(HeapSet.HeapNode heapArray [], int index){
		// correct a single violation of the heap
		// property in a subtree at its root
	}
	
	public void heapSort(){
		
	}

}
