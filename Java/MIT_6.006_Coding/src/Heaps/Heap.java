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
	
	// This function is used to insert into the array
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
	private int parent(int index){
		return (index - 1)/2;
	}

	
	// create a heap from an un-Ordred array 
	public void buildMaxHeap() {
		System.out.println("Building the heap..");
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
	
	// extract and remove the maximum from the heap
	// resize the heap
	public HeapItem ExtractMax(){
		// always create a new temporary variable rather tha just assigning
		// learn from the mistakes of BST code
		HeapItem max = new HeapItem(this.items[0].key);
		this.items[0] = this.items[this.size-1];
		this.items[this.size-1] = max;
		this.size = this.size-1;
		maxHeapify(this.items, 0);
		System.out.println("Extracting Max: " + max.key);
		return max;
	}
	
	public void IncreaseKey(int i, int value) {
		// validate index first
		if (i >= this.size || index < 0){
			System.out.println("Invalid Index of Item");
			return;
		}
		// check if given key is valid
		if (this.items[i].key >= value) {
			System.out.println("Current Key is larger");
			return;
		}
		this.items[i].key = value;
		while (i > 0 && this.items[parent(i)].key < this.items[i].key) {
			// exchange a[i] with a[parent(i)]
			HeapItem temp = new HeapItem(this.items[parent(i)].key);
			this.items[parent(i)] = this.items[i];
			this.items[i] = temp;
			// reset the parent
			i = parent(i);
		}
		
	}
	
}
