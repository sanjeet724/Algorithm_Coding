package AVLTree;

class AVLNode {
	int key;
	int height;
	boolean isUnbalanced;
	AVLNode parent;
	AVLNode right;
	AVLNode left;
	
	public AVLNode(int k) {
		this.key = k;
		this.height = 0;
		this.left = null;
		this.right = null;
		this.parent = null;
		this.isUnbalanced = true;
		
	}
	// temporary node used during re-balancing
	private AVLNode(AVLNode n) {
		this.key = n.key;
		this.height = n.height;
		this.left = n.left;
		this.right = n.right;
		this.parent = null; // set the parent to null, because this is the only one we care about
		this.isUnbalanced = true;
	}
	
	public void updateHeights(){
		this.updateSelfHeight();
		this.updateAncestorHeight();
	}
	
	// Given a node, update its height after an insertion operation
	private void updateSelfHeight(){
		if (this.left == null && this.right == null){
			this.height = 0;
			return;
		}
		if (this.left == null && this.right != null){
			this.height = this.right.height + 1;
			return;
		}
		else if (this.right == null && this.left != null) {
			this.height = this.left.height + 1;
			return;
		}
		else {
			if (this.left.height > this.right.height){
				this.height = this.left.height + 1;
			}
			else {
				this.height = this.right.height + 1;
			}
			return;
		}
	}
	
	// Given a node, update its ancestor's height 
	// till the root after an insertion;
	private void updateAncestorHeight(){
		AVLNode current = this;
		if (current.parent != null ) {
			current.parent.updateSelfHeight();
			current = current.parent;
			current.updateAncestorHeight();
		}
	}
	
	// after each insert check if
	// height of left child - height of right child <= 1
	// for all of the ancestors
	public AVLNode checkAVLProperty(){
		AVLNode current = this;
		if (current.parent != null) {	
		   if (checkBalance(current) != null){
			   return current;
		   }
		  // recurse till you reach root
		  current = current.parent;
		  return current.checkAVLProperty(); 
		}
		// base case - root
		if (checkBalance(current) != null){
			return current;
		}
		return null;
	}
	
	private AVLNode checkBalance(AVLNode n){
		   int leftHeight = getLeftHeight(n);
		   int rightHeight = getRightHeight(n);
		   if (Math.abs(leftHeight-rightHeight) > 1){
			   System.out.println("AVL property violated");
			   System.out.println("Violated Node: " + n.key);
			   n.isUnbalanced = false;
			   return n;
		   }
		   n.isUnbalanced = true;
		   return null;
		}
	
	public void Rotate(){
		boolean zigzag;
		AVLNode toRotate = this;
		int leftHeight = getLeftHeight(toRotate);
		int rightHeight = getRightHeight(toRotate);
		if (rightHeight > leftHeight) {
			zigzag = checkZigZagHeaviness(toRotate.right);
			if (zigzag){
				System.out.println("Performing left rotation for: " + toRotate.right.key);
				RotateLeftZigZag(toRotate.right.left);
			}
			System.out.println("Performing left rotation for: " + toRotate.key);
			RotateLeft(toRotate); // right heavy, do left rotation
		}
		else {
			zigzag = checkZigZagHeaviness(toRotate.left);
			if (zigzag){
				System.out.println("Performing right rotation for: " + toRotate.left.right.key);
				RotateRightZigZag(toRotate.left.right);
			}
			else {
				System.out.println("Performing right rotation for: " + toRotate.key);
				RotateRight(toRotate);  // left heavy, do right rotation
			}
		}
	}
	
	private boolean checkZigZagHeaviness(AVLNode n){
		int leftHeight = getLeftHeight(n);
		int rightHeight = getRightHeight(n); 
		if (rightHeight > leftHeight){
			if (n.parent.left == n){
				// n is a left child
				System.out.println("Left-Right Zig-Zag Heavyness Detected for: " + n.parent.key);
				return true;
			}
		}
		else {
			if (n.parent.right == n){
				// n is a right child
				System.out.println("Right-Left Zig-Zag Heavyness Detected for: " + n.parent.key);
				return true;
			}
		}
		return false;
	}
	
	
	private AVLNode createTemporaryNode(AVLNode n){
		if (n == null)
			return null;
		return new AVLNode(n);
	}
  
	private void RotateLeft(AVLNode x){
		AVLNode y = x.right;
		y.parent = x.parent;
		if (x.parent != null) {
			if (x.parent.left == x) {
				// i.e if x was a left child
				x.parent.left = y;	
			}
			else {
				x.parent.right = y;
			}
		}
		AVLNode temp = createTemporaryNode(y.left);
		y.left = x;
		x.parent = y;
		if (temp != null){
			x.right = temp;
			temp.parent = x;
		}
		else {
			x.right = null;
		}
		x.height = x.height - 2;
		x.updateHeights();
	}
	
	private void RotateRight(AVLNode x){
		AVLNode y = x.left;
		y.parent = x.parent;
		if (x.parent != null){
			if (x.parent.left == x) {
				// i.e if x was a left child
				x.parent.left = y;
			}
			else {
				x.parent.right = y;
			}
		}
		AVLNode temp = createTemporaryNode(y.right);
		y.right = x;
		x.parent = y;
		if (temp != null){
			x.left = temp;
			temp.parent = x;
		}
		else {
			x.left = null;
		}
		x.height = x.height - 2;
		x.updateHeights();
	}
	
	private void RotateLeftZigZag(AVLNode n){
		// To be implemented
	}
	
	
	private void RotateRightZigZag(AVLNode n){
		// To be implemented
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
