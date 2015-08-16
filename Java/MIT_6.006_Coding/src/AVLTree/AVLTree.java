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
			this.root.height++;
			return; 
		}
		if (n.key < temp.key){
			temp.left = n;
			if (temp.right == null) {
				temp.height = n.height + 1;
			}
			else {
				temp.height = temp.right.height + 1;
			}
		}
		else {
			temp.right = n;
			if (temp.left == null) {
				temp.height = n.height + 1;
			}
			else {
				temp.height = temp.left.height + 1;
			}
		}
		updateHeights(temp);
	}
	
	public void updateHeights(AVLNode p) {
		AVLNode current = p;
		if (current.parent != null ){
			current.height++;
			current = current.parent;
			updateHeights(current);
		}
		// we are at root - base case
        if (current.left == null ){
        	current.height = current.right.height + 1 ;
        	return;
        }
        else if (current.right == null){
        	current.height = current.left.height + 1;
        	return;
        }
        else {
        	if (current.left.height > current.right.height){
        		current.height = current.left.height + 1;
        	}
        	else {
        		current.height = current.right.height + 1;
        	}
        	return;
        }
	}
	
	public int getHeightofTree(){
		return this.root.height;
	}
	
	
	public void inOrderTraversal(){
		
	}

}
