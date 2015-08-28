package Heaps;

// Given Input - Collection of heap nodes
class HeapSet {
	HeapNode [] unOrderedCollection;
	int index;
	int size;
	
	public HeapSet(int s){
		this.index = 0;
		this.size = s;
		this.unOrderedCollection = new HeapNode[this.size];
	}
	
	public void addItem(HeapNode h) {
		this.unOrderedCollection[this.index] = h;
		this.index++;
	}
}
