package AVLTree;

public class AVLTree {
	AVLNode root;
	AVLNode heavy;
	

	public AVLTree(){
	}
	
	public void insertNode (int k) {
		System.out.println("Inserting key: " + k);
		AVLNode newNode = new AVLNode(k);
		AVLNode current = this.root;  // pointer to move from root to position of insert
		AVLNode wouldBeParent = null; // would be parent-node where 'newNode' will be inserted
		while (current != null) {
			wouldBeParent = current;
			if (newNode.key < current.key){
				current = current.left;
			}
			else {
				current = current.right;
			}
		}
		// insert at this position
		newNode.parent = wouldBeParent;
		if (wouldBeParent == null) {
			this.root = newNode;
			return; 
		}
		if (newNode.key < wouldBeParent.key){
			wouldBeParent.left = newNode;
		}
		else {
			wouldBeParent.right = newNode;
		}
		// update the heights of the parent
		// and ancestors till the root
		wouldBeParent.updateHeights();
		System.out.println("Would be parent is: " + wouldBeParent.key);
		// check if AVL Property is maintained
		this.heavy = wouldBeParent.checkAVLProperty();
		while (this.heavy != null){
			this.heavy.Rotate();
			this.heavy = wouldBeParent.checkAVLProperty();
		}
		// root might have changed
		resetRoot();
	}
	
	// this method updates the root
	// roots might have changed after rotations
	private void resetRoot(){
		while (this.root.parent != null){
			this.root = this.root.parent;
		}
	}

	public int getHeightofTree(){
		/* we are re-setting the root in insert,so not needed for now
		if (this.root.parent != null){
			resetRoot();
		}*/
		return this.root.height;
	}
	
	public void InorderTraveral(){
		Inorder(this.root);
	}
	
	private void Inorder(AVLNode n){
		AVLNode current = n;
		if (current != null){
			current  = n.left;
			Inorder(current);
			System.out.printf("%02d ", n.key);
			current = n.right; 
			Inorder(current);
		}
	}
}
