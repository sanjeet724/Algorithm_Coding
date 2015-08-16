package AVLTree;


public class AVLTree {
	AVLNode root;
	boolean AVLProperty;
	
	public AVLTree() {
		this.AVLProperty = true;
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
		// update the height of the parent
		wouldBeParent.updateParentHeight();
		// update the heights' of the ancestors
		wouldBeParent.updateAncestorHeight();
		// check if AVL Property is maintained
		this.AVLProperty = wouldBeParent.checkAVLProperty();
	}
	
	public int getHeightofTree(){
		return this.root.height;
	}
	
	public void inOrderTraversal(){
		
	}

}
