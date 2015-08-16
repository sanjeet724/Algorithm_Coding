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
	
	public void check_balance(AVLNode n) {
		if(Math.abs(n.left.height - n.right.height) > 1) {
			System.out.println("Imbalanced AVL detected");
		}
	}

}
