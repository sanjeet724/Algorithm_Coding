package AVLTree;


public class AVLTree {
	AVLNode root;

	
	AVLTree() {
	}
	
	public void insertNode (int k) {
		System.out.println("Inserting key: " + k);
		AVLNode n = new AVLNode(k);
		AVLNode current = this.root; // pointer to move from root to position of insert
		AVLNode temp = null;         // would be parent-node where 'n' will be inserted
		while (current != null) {
			temp = current;
			if (n.key < current.key){
				current = current.left;
			}
			else {
				current = current.right;
			}
		}
		// insert at this position
		n.parent = temp;
		if (temp == null) {
			this.root = n;
			return; 
		}
		if (n.key < temp.key){
			temp.left = n;
		}
		else {
			temp.right = n;
		}
		updateHeights(n);
	}
	
	public void updateHeights(AVLNode n) {
		/*
		AVLNode current = n;
		// base case
		if (current.parent == null){
			if (current.left.height > current.right.height){
				current.height = current.left.height + 1;
			}
			else {
				current.height = current.right.height + 1;
			}
		}
		else {
			current = current.parent;
			if (current.left.height > current.right.height){
				current.height = current.left.height + 1;
			}
			else {
				current.height = current.right.height + 1;
			}
			updateHeights(current);
		}
		*/
		AVLNode current = n.parent;
		while (current != null){
			if (current.left.height > current.right.height){
				current.height = current.left.height + 1;
			}
			else {
				current.height = current.right.height + 1;
			}
			current = current.parent;
		}
		
	}
	
	public int getHeightofTree(){
		return this.root.height;
	}
	
	
	public void inOrderTraversal(){
		
	}

}
