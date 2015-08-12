package AVLTree;

class AVLNode {
	int key;
	int height;
	AVLNode parent;
	AVLNode right;
	AVLNode left;
	
	public AVLNode(int k) {
		this.height = 0;
		this.parent = null;
		this.right = null;
		this.left = null;
	}
	
	public AVLNode(int k, AVLNode p, boolean insertLeft){
		this.key = k;
		this.height = 0;
		this.parent = p;
		if (insertLeft) {
			p.left = this;
			p.right = null;
		}
		else {
			p.right = this;
			p.left = null;
		}
		update_height(p);
		check_balance(p);
	}
	
	public void update_height(AVLNode n){
		if (n.parent != null) {
			n = n.parent;
			update_height(n);
		} else {
			if (n.left.height > n.right.height){
				n.height = n.left.height + 1;
			}
			else {
				n.height = n.right.height + 1;
			}
		}
	}
	
	public void check_balance(AVLNode n) {
		if(Math.abs(n.left.height - n.right.height) > 1) {
			System.out.println("Imbalanced AVL detected");
		}
	}

}
