package Heaps;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HeapDriver {

	public static void main(String[] args) throws IOException{
        // create a heap-set
		HeapSet hs = new HeapSet();
		System.out.println("Reading the input file... ");
		Scanner scanner = new Scanner(new File("inputKeys.txt"));
		while (scanner.hasNextInt()){
			HeapSet.HeapNode  h = hs.new HeapNode(scanner.nextInt());
			hs.addItem(h);
		}
		scanner.close();
	}

}
