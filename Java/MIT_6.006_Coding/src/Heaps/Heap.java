package Heaps;

// Given Input - Collection of heap items
class Heap {
	HeapItem [] items;
	int index;
	int size;
	
	public Heap(int s){
		this.index = 0;
		this.size = s;
		this.items = new HeapItem[this.size];
	}
	
	public void addItem(HeapItem h) {
		this.items[this.index] = h;
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
	
	// return the index of the parent
	/*
	private int parent(int index){
		return (index - 1)/2;
	}
	*/
	
	public void buildMaxHeap() {
		for (int i = this.size/2 - 1 ; i >=0; i--) {
			maxHeapify(this.items, i);
		}
		this.printHeap();
	}
	
	 //correct a single violation of the heap
	 //property in a subtree at its root
	private void maxHeapify(HeapItem [] heapArray, int index){
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
			HeapItem temp = new HeapItem(heapArray[largest].key);
			heapArray[largest] = heapArray[index];
			heapArray[index] = temp;
			maxHeapify(heapArray, largest);
		}
		return;
	}
	
	public void heapSort(){
		// first build the heap in case its not built
		this.buildMaxHeap(); 
		// swap 1st element with last one
		System.out.println("Performing Heap-Sort");
		while (this.size != 0){
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
		System.out.println("Heap Built: ");
		for (int i = 0; i < this.size ;i++){
			System.out.printf("%d ", this.items[i].key);
		}
		System.out.println();
	}
}
