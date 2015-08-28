package Heaps;

// This is a node/item that will make up the unordered collection
public class HeapNode {
	int key;
	
	HeapNode(int k){
		System.out.println("HeapNode created with key: " + k);
		this.key = k;
	}
}
