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
		while (current.parent != null) {	
		   if (checkBalance(current)){
			   return false;
		   }
		  // recurse till you reach root
		  current = current.parent;
		  current.checkAVLProperty(); 
		}
		// base case - root
		if (checkBalance(current)){
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
