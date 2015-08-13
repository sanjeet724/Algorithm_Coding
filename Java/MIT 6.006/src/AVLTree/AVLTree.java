package AVLTree;

public class AVLTree {
	Node root;
	AVLTree parentTree;
	AVLTree leftSubtree;
	AVLTree rightSubtree;
	int height;
	
	
	AVLTree() {
		this.root= null;
		this.parentTree = null;
		this.leftSubtree = null;
		this.rightSubtree = null;
		this.height = -1;
	}
	
	public void insertNode (int k) {
		System.out.println("Inserting key: " + k);
		Node n = new Node(k);
		if (this.root == null ) {
			this.root = n;
			this.height = 0;
			return;
		}
		// find position of insert
		Node current = this.root;
		Node temp = null;
		while (current != null) {
			temp = current;
			if (n.key < current.key){
				current = this.leftSubtree.root;
			}
			else {
				current = this.rightSubtree.root;
			}
		}
		// insert at this position
		this.parentTree.root = temp;
		if (n.key < temp.key){
			this.leftSubtree.parentTree.root = temp;
			this.leftSubtree.root = n;
			this.leftSubtree.height = 0;
			this.leftSubtree.parentTree.height++;
		}
		else {
			this.rightSubtree.parentTree.root = temp;
			this.rightSubtree.root = n;
			this.rightSubtree.height = 0;
			this.rightSubtree.parentTree.height++;
		}
	}
	
	public void inOrderTraversal(){
		
	}

}
