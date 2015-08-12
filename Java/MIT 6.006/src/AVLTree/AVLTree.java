package AVLTree;

public class AVLTree {
	AVLNode root;
	
	private static AVLTree AVL = new AVLTree();
	
	AVLTree() {
		
	}
	
	public static AVLTree getAVLTree(){
		return AVL;
	}
}
