// Given Input : Array of some items with keys
// Output - 1) A max heap 
//        - 2) Heap Sort
package Heaps;

class Heap {
	HeapItem [] items;
	int index;
	int size;      // the actual size of the heap
	int capacity;  // the capacity of the heap
	
	public Heap(){
		this.capacity = 25;
		this.index = 0;
		this.items = new HeapItem[this.capacity];
	}
	
	// Add items to the array
	public void addItem(HeapItem h) {
		this.items[this.index] = h;
		this.size++;
		this.index++;
	}
	
	// return the index of the left child
	private int left(int index){
		return 2*index + 1;
	}
	
	// return the index of the right child
	private int right(int index){
		return 2*index + 2;
	}
	
	
	// create a heap from an un-Ordred array 
	public void buildMaxHeap() {
		System.out.println("Heapyfying the array");
		for (int i = this.size/2 - 1 ; i >=0; i--) {
			maxHeapify(this.items, i);
		}
		this.printHeap();
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
	
	public void heapSort(){
		// first build the heap in case its not built
		// this.buildMaxHeap(); 
		System.out.println("Performing Heap-Sort");
		while (this.size != 0){
			// swap 1st element with last one
			HeapItem temp = new HeapItem(this.items[0].key);
			this.items[0] = this.items[this.size-1];
			this.items[this.size-1] = temp;
			System.out.printf("%d ",this.items[this.size-1].key);
			this.size = this.size - 1;
			// after the swap verify the max-heap property for the new root
			maxHeapify(this.items, 0);
		}
	}
	
	public void printHeap() {
		System.out.println("Printing the heap..");
		for (int i = 0; i < this.size ;i++){
			System.out.printf("%d ", this.items[i].key);
		}
		System.out.println();
	}

}
