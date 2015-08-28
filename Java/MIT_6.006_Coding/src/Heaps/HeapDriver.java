package Heaps;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HeapDriver {

	public static void main(String[] args) throws IOException{
        // create a heap-set
		HeapSet hs = new HeapSet(3);
		System.out.println("Reading the input file... ");
		Scanner scanner = new Scanner(new File("inputKeys.txt"));
		while (scanner.hasNextInt()){
			HeapNode  h = new HeapNode(scanner.nextInt());
			hs.addItem(h);
		}
		scanner.close();
	}

}
