package Heaps;

import sun.security.util.Length;

public class PriorityQueue {
	HeapNode [] maxHeap;
	
	public PriorityQueue(HeapSet h){
		this.maxHeap = new HeapNode[h.size];
		for (int i = 0; i < h.size; i++) {
			this.maxHeap[i] = h.unOrderedCollection[i];
		}
		buildMaxHeap(this.maxHeap);
	}
	
	// return the index of the left child
	private int left(int index){
		return index*2;
	}
	
	// return the index of the right child
	private int right(int index){
		return 2*index + 1;
	}
	
	// return the index of the parent
	private int parent(int index){
		return index/2;
	}
	

	private void buildMaxHeap(HeapNode [] heapArray) {
		for (int i = heapArray.length/2 ; i >=0; i--) {
			maxHeapify(heapArray, i);
		}
	}
	
	 //correct a single violation of the heap
	 //property in a subtree at its root
	private void maxHeapify(HeapNode [] heapArray, int index){
		int l = left(index);
		int r = right(index);
		int p = parent(index);
		int largest;
		// To be implemented
	}

}
