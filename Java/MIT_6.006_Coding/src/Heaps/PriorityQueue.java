package Heaps;

public class PriorityQueue {
	HeapItem [] heap;
	int capacity;
	int size;
	
	public PriorityQueue(){
		this.capacity = 25;
		this.heap = new HeapItem[this.capacity];
	}
	
	// return the index of the left child
	private int left(int index){
		return 2*index + 1;
	}
	
	// return the index of the right child
	private int right(int index){
		return 2*index + 2;
	}
	
	// return the index of the parent
	private int parent(int index){
		return (index - 1)/2;
	}
	
	public void IncreaseKey(int i, int value) {
		// validate index first
		// System.out.println("Changing key for index " + i + " to " + value);
		if (i >= this.capacity || i < 0){
			System.out.println("Invalid Index of Item");
			return;
		}
		// check if given key is valid
		if (this.heap[i].key >= value) {
			System.out.println("Current Key is larger than given value");
			return;
		}
		this.heap[i].key = value;
		while (i > 0 && this.heap[parent(i)].key < this.heap[i].key) {
			// exchange a[i] with a[parent(i)]
			HeapItem temp = new HeapItem(this.heap[parent(i)].key);
			this.heap[parent(i)] = this.heap[i];
			this.heap[i] = temp;
			// reset the parent
			i = parent(i);
		}
	}
	
	public void InsertIntoHeap(int newKey){
		System.out.println("Inserting into the heap: " + newKey);
		this.size = this.size + 1;
		HeapItem temp = new HeapItem(-999999);
		this.heap[this.size-1] = temp;
		this.IncreaseKey(this.size-1, newKey);
	}	
	
	 //correct a single violation of the heap
	 //property in a subtree at its root
	public void maxHeapify(HeapItem [] heapArray, int index){
		int l = left(index);
		int r = right(index);
		int largest = index;
		if ( l <= this.size-1 && heapArray[l].key > heapArray[index].key){
			largest = l;
		}
		if ( r <= this.size-1 && heapArray[r].key > heapArray[largest].key){
			largest = r;
		}
		if (largest != index){
			// swap
			HeapItem temp = new HeapItem(heapArray[largest].key);
			heapArray[largest] = heapArray[index];
			heapArray[index] = temp;
			// after the swap verify the max-heap property
			maxHeapify(heapArray, largest);
		}
		return;
	}
	
	public HeapItem ExtractMax(){
		// always create a new temporary variable rather tha just assigning
		// learn from the mistakes of BST code
		// swap first and last elements
		HeapItem max = new HeapItem(this.heap[0].key);
		this.heap[0] = this.heap[this.size-1];
		this.heap[this.size-1] = max;
		this.size = this.size-1;
		// check the heap property because of the swap
		maxHeapify(this.heap, 0);
		System.out.println("Extracting Max: " + max.key);
		return max;
	}
	
	public void printHeap() {
		System.out.println("Printing the heap..");
		for (int i = 0; i < this.size ;i++){
			System.out.printf("%d ", this.heap[i].key);
		}
		System.out.println();
	}

}
