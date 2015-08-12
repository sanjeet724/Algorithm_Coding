package BinarySearchTree;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BSTDriver {

	public static void main(String[] args) throws IOException {
		
		BST bst = BST.getBST();
		System.out.println("Reading the input file... ");
		Scanner scanner = new Scanner(new File("inputKeys.txt"));
		while (scanner.hasNextInt()){
			Node n = new Node(scanner.nextInt());
			bst.insertNode(n);
		}
		scanner.close();
		Node min = bst.FindMin();
		System.out.printf("\nMinimum of the BST is %02d \n", min.key);
		Node max = bst.FindMaxR();
		System.out.printf("Maximum of the BST is %02d \n", max.key);
		// find a given key - we have 2 implementations for search
		// iterative and recursive
		// Node f = bst.IterativeSearch(15);
		/*
		Node f = bst.RecursiveSearch(15);
		if (f == null) {
			System.out.println("Key not found");
		}
		else {
			System.out.println("Key found\n");
		}
		*/
		System.out.println("Inorder Traversal before delete: ");
		bst.InorderTraversal();
		System.out.println("\nHeight of the BST before delete is: " + bst.getHeightofBST());
		// bst.RepresentationInvariant();
		// System.out.println("Enter the key you want to find next larger: ");
		System.out.println("Enter the key you want to delete: ");
		Scanner in = new Scanner(System.in);
		int keyTobeDeleted = in.nextInt();
		
		bst.deleteNode(keyTobeDeleted);
		System.out.println("Inorder Traversal after delete: ");
		bst.InorderTraversal();
		System.out.println("\nHeight of the BST after delete is: " + bst.getHeightofBST());

		/*
		Node nextLarger = bst.nextLarger(keyTobeDeleted);
		
		if (nextLarger == null) {
			System.out.println("nextLarger not found");
		}
		else {
			System.out.println("nextLarger is: " + nextLarger.key);
		}
		*/
		in.close();
	}
}
 