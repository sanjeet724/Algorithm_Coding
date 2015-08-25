package Heaps;

class HeapSet {

	HeapNode [] heapCollection;
	int index;
	int size;
	
	// Inner class
    class HeapNode {
		int key;
		public HeapNode(int k){
			this.key = k;
			System.out.println("HeapNode created with key: " + k);
		}
	}
	
	public HeapSet(){
		this.index = 0;
		this.size = 10;
		this.heapCollection = new HeapNode[this.size];
	}
	
	public void addItem(HeapNode h) {
		this.heapCollection[this.index] = h;
		this.index++;
	}
}
