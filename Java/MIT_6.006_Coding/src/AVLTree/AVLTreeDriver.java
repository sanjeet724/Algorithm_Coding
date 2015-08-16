package AVLTree;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;



public class AVLTreeDriver {

	public static void main(String[] args) throws IOException {

    AVLTree avl = new AVLTree();
	System.out.println("Reading the input file... ");
	Scanner scanner = new Scanner(new File("inputKeys.txt"));
	while (scanner.hasNextInt()){
		int n = scanner.nextInt();
		avl.insertNode(n);
	}
	scanner.close();
	System.out.println("Height of Tree is: " + avl.getHeightofTree());
    
	}

}