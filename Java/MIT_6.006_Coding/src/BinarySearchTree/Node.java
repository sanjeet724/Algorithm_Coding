package BinarySearchTree;

class Node {
	int key;
	Node parent;
	Node leftChild;
	Node rightChild;
	
	public Node(int k) {
		key = k;
		parent = null;
		leftChild = null;
		rightChild = null;
	}
	
	// to avoid nullpointer exception errors
	public Node getLeft() {
		if (this.leftChild instanceof Node){
			return this.leftChild;
		}
		return null;
	}
	
	public Node getRight() {
		if (this.rightChild instanceof Node){
			return this.rightChild;
		}
		return null;
	}
	
	public Node getParent() {
		if (this.parent instanceof Node){
			return this.parent;
		}
		return null;
	}
	
	// checks if the node is a left child
	public boolean isLeftChild() {
		if (this.getParent().getLeft() instanceof Node && 
			    this.getParent().getLeft().key == this.key){
			return true;
		}
		return false;
	}
	
	// reset child pointer
	public void resetChildPointers(Node n, boolean isleftChild){
		if (isleftChild) {
			this.parent.leftChild = n;
		}
		else {
			this.parent.rightChild = n;
		}
	}
	
    // resets the left/right child and parent pointers
	public void resetParentChildPointers(boolean hasLeftChild, boolean isLeftChild){
		if (hasLeftChild) {
			this.leftChild.parent = this.parent;
			if (isLeftChild) {
				this.parent.leftChild = this.leftChild;
			}
			else {
				this.parent.rightChild = this.leftChild;
			}
			
		}
		// has a right child
		else {
			this.rightChild.parent = this.parent;
			if (isLeftChild) {
				this.parent.leftChild = this.rightChild;
			}
			else {
				this.parent.rightChild = this.rightChild;
			}
			
		}
	}
	
	
	
	
}
