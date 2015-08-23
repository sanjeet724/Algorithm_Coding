package AVLTree;


public class AVLTree {
	AVLNode root;
	AVLNode heavy;

	public AVLTree() {

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
		System.out.println("Inserting as a child of: " + wouldBeParent.key);
		wouldBeParent.updateHeights();
		// check if AVL Property is maintained
		this.heavy = wouldBeParent.checkAVLProperty();
		if (this.heavy != null){
			this.heavy.Rotate();
			this.heavy = wouldBeParent.checkAVLProperty();
		}
	}
	
	// this method updates the root
	// roots might have changed after rotations
	
	private void resetRoot(){
		while (this.root.parent != null){
			this.root = this.root.parent;
		}
	}

	public int getHeightofTree(){
		if (this.root.parent != null){
			resetRoot();
		}
		System.out.println("Root is: " + this.root.key);
		return this.root.height;
	}

}
