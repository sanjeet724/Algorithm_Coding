package AVLTree;

class AVLNode {
	int key;
	int height;
	AVLNode parent;
	AVLNode right;
	AVLNode left;
	
	public AVLNode(int k) {
		this.key = k;
		this.height = 0;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	// Given a parent node, update its height after an insertion operation
	public void updateParentHeight(){
		if (this.left == null){
			this.height = this.right.height + 1;
		}
		else if (this.right == null) {
			this.height = this.left.height + 1;
		}
		else {
			if (this.left.height > this.right.height){
				this.height = this.left.height + 1;
			}
			else {
				this.height = this.right.height + 1;
			}
		}
	}
	
	// Given a parent node, update its ancestor's height after an insertion;
	public void updateAncestorHeight(){
		AVLNode current = this;
		if (current.parent != null ) {
			current.parent.updateParentHeight();
			current = current.parent;
			current.updateAncestorHeight();
		}
		// base case (root) - so just update the height
		current.updateParentHeight();
	}
	
	// after each insert check if
	// height of left child - height of right child <= 1
	// for all of the ancestors
	public boolean checkAVLProperty(){
		AVLNode current = this;
		if (current.parent != null) {	
		   if (checkBalance(current)){
			   // Rotate(current);
			   return false;
		   }
		  // recurse till you reach root
		  current = current.parent;
		  return current.checkAVLProperty(); 
		}
		// base case - root
		if (checkBalance(current)){
			// Rotate(current);
			return false;
		}
		return true;
	}
	
	private boolean checkBalance(AVLNode n){
		   int leftHeight = getLeftHeight(n);
		   int rightHeight = getRightHeight(n);
		   if (Math.abs(leftHeight-rightHeight) > 1){
			   System.out.println("AVL property violated");
			   System.out.println("Violated Node: " + n.key);
			   return true;
		   }
		   return false;
		}
	
	public void Rotate(){
		AVLNode toRotate = this;
		int leftHeight = getLeftHeight(toRotate);
		int rightHeight = getRightHeight(toRotate);
		if (rightHeight > leftHeight) {
			RotateLeft(toRotate); // right heavy, do left rotation
		}
		else {
			RotateRight(toRotate);  // left heavy, do right rotation
		}
	}
  
	private void RotateLeft(AVLNode x){
		System.out.println("Performing left rotation");
		AVLNode y = x.right;
		x.parent = x.parent;
		x.parent = y;
		y.left = x;
		x.right = y.left;
	}
	
	private void RotateRight(AVLNode n){
		
	}
	
	
	private int getLeftHeight(AVLNode n) {
		if (n.left != null){
			return n.left.height;
		}
		else return -1;
	}
	
	private int getRightHeight(AVLNode n) {
		if (n.right != null){
			return n.right.height;
		}
		else return -1;
	}

}
